package cn.hncu.service.impl;

import cn.hncu.mapper.CategoryMapper;
import cn.hncu.mapper.NewsImageMapper;
import cn.hncu.mapper.NewsMapper;
import cn.hncu.pojo.*;
import cn.hncu.service.INewsService;
import cn.hncu.utils.FastDFSClient;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsImageMapper imageMapper;

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private CategoryMapper categoryMapper;



    @Override
    public void insert(NewsWithImages newsWithImages) throws IOException, SolrServerException {
        if (newsWithImages == null)
            return;
        News news = newsWithImages.getNews();
        //插入数据库
        newsMapper.insert(news);
        //插入solr
        SolrInputDocument solrDoc = new SolrInputDocument();

        //news表
        solrDoc.setField("id",news.getId());
        solrDoc.setField("km_news_title",news.getTitle());
        solrDoc.setField("km_news_release_date",news.getReleaseDate());
        solrDoc.setField("km_news_content",news.getContent());
        solrDoc.setField("km_news_source",news.getSource());
        solrDoc.setField("km_news_image",news.getImage());
        solrDoc.setField("km_news_comment_count",0);
        solrDoc.setField("km_news_visit_count",0);

        //userinfo表
        solrDoc.setField("km_user_id",1);
        solrDoc.setField("km_user_name","系统用户");
        solrDoc.setField("km_user_image","http://192.168.25.136/group1/M00/00/00/wKgZiFy5cbuAPutBAAAdmrE4e_4288.png");
        //category表
        Category category = categoryMapper.selectByPrimaryKey(news.getCid());
        solrDoc.setField("km_category_text",category.getText());

        solrClient.add(solrDoc);
        solrClient.commit();
        System.out.println("已爬取 ： " + newsWithImages.getNews().getTitle());

        Integer nid = newsWithImages.getNews().getId();
        newsWithImages.getImages().forEach(newsImage -> {
            newsImage.setNid(nid);
            imageMapper.insert(newsImage);
        });
    }


    /**
     * 根据id删除图片
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void deleById(Integer id) throws Exception {
        //查询该新闻，用于写日志  暂时为控制台输出
        News news = newsMapper.selectByPrimaryKey(id);
        System.out.print(new Date());
        System.out.println("准备删除新闻id:" + news.getId() + ",标题 : " + news.getTitle());
        //获取fdfs客户端工具类对象
        FastDFSClient fastDFSClient = new FastDFSClient();

        //查询该新闻的所有图片
        NewsImageExample imageExample = new NewsImageExample();
        NewsImageExample.Criteria imageExampleCriteria = imageExample.createCriteria();
        imageExampleCriteria.andNidEqualTo(id);
        List<NewsImage> newsImages = imageMapper.selectByExample(imageExample);
        //遍历图片集合
            newsImages.forEach(newsImage -> {
                try {
                    //从fdfs服务器删除该图片
                    String url = newsImage.getUrl();
                    fastDFSClient.deleteFile(url, "http://192.168.25.136/");
                    //伪日志
                    System.out.println("从fdfs删除文件 : " + newsImage.getUrl());
                    //从数据库删除该图片url
                    imageMapper.deleteByPrimaryKey(newsImage.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        //从mysql删除该新闻
        newsMapper.deleteByPrimaryKey(id);
        //从solr删除该新闻
        solrClient.deleteById(id+"");
        solrClient.commit();
        System.out.print(new Date() + " : ");
        System.out.println("已删除新闻id:" + news.getId() + ",标题 : " + news.getTitle());
    }

    @Override
    public void deleOldNews() {
        System.out.print(new Date() + " : ");
        System.out.println("开始批量删除爬取的过时新闻");
        //查询所有爬取的新闻
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(1);
        //三天前
        long time = new Date().getTime() - 1000 * 60 * 60 * 24 * 3;
        Date limit = new Date(time);
        criteria.andReleaseDateLessThan(limit);
        List<News> newsList = newsMapper.selectByExample(example);

        //按照id删除每一条
        newsList.forEach(news -> {
            try {
                deleById(news.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("爬取的新闻删除结束");
    }
    /**
     * 判断新闻是否存在于数据库中
     *
     * @param source
     * @return
     */
    @Override
    public boolean isExists(String source) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andSourceEqualTo(source);
        List<News> newsList = newsMapper.selectByExample(example);
        if (newsList.size() > 0) {
            return true;
        }
        return false;
    }
}
