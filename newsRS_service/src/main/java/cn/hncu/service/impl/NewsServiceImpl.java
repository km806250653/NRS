package cn.hncu.service.impl;

import cn.hncu.entity.PageResult;
import cn.hncu.mapper.CommentMapper;
import cn.hncu.mapper.NewsImageMapper;
import cn.hncu.mapper.NewsMapper;
import cn.hncu.pojo.*;
import cn.hncu.pojo_group.NewsWithImages;
import cn.hncu.service.INewsService;
import cn.hncu.utils.FastDFSClient;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private CommentMapper commentMapper;



    @Override
    public News findOne(Integer id) {

        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(NewsWithImages newsWithImages) {
        if (newsWithImages ==null)
            return;
        System.out.println("已爬取 ： "+ newsWithImages.getNews().getTitle());
        newsMapper.insert(newsWithImages.getNews());
        Integer nid = newsWithImages.getNews().getId();
        newsWithImages.getImages().forEach(newsImage -> {
            newsImage.setNid(nid);
            imageMapper.insert(newsImage);
        });
    }


    @Override
    public PageResult findListByCid(Integer cid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        NewsExample example =new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        Page<News> page = (Page<News>) newsMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据id删除图片
     * @param id
     * @throws Exception
     */
    @Override
    public void deleById(Integer id) throws Exception {
        //查询该新闻，用于写日志  暂时为控制台输出
        News news = newsMapper.selectByPrimaryKey(id);
        System.out.print(new Date());
        System.out.println("准备删除新闻id:"+news.getId()+",标题 : "+news.getTitle());
        //获取fdfs客户端工具类对象
        FastDFSClient fastDFSClient = new FastDFSClient("classpath:fast_dfs_client.conf");

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
                fastDFSClient.deleteFile(url,"http://192.168.25.136/");
                //伪日志
                System.out.println("从fdfs删除文件 : "+newsImage.getUrl());
                //从数据库删除该图片url
                imageMapper.deleteByPrimaryKey(newsImage.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //删除该新闻的评论
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria commentExampleCriteria = commentExample.createCriteria();
        commentExampleCriteria.andNidEqualTo(id);
        commentMapper.deleteByExample(commentExample);
        System.out.println("评论删除完毕");

        //删除该新闻
        newsMapper.deleteByPrimaryKey(id);
        System.out.print(new Date()+" : ");
        System.out.println("已删除新闻id:"+news.getId()+",标题 : "+news.getTitle());
    }

    @Override
    public void deleCrawlNews()  {
        System.out.print(new Date()+" : ");
        System.out.println("开始批量删除爬取的新闻");
        //查询所有爬取的新闻
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(1);
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
     * @param source
     * @return
     */
    @Override
    public boolean isExists(String source) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andSourceEqualTo(source);
        List<News> newsList = newsMapper.selectByExample(example);
        if(newsList.size()>0){
            return true;
        }
        return false;
    }
}
