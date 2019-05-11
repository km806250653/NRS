package cn.hncu.service.impl;

import cn.hncu.entity.PageResult;
import cn.hncu.mapper.*;
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

    @Autowired
    private FavoritesMapper favoritesMapper;



    @Override
    public News findOne(Integer id) {

        return newsMapper.selectByPrimaryKey(id);
    }



    @Override
    public PageResult findListByCid(Integer cid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        Page<News> page = (Page<News>) newsMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public PageResult findListByUid(Integer uid, int pageNum) {
        PageHelper.startPage(pageNum, 4);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("release_date desc");
        criteria.andUidEqualTo(uid);
        //长文本需使用该方法
        Page<News> page = (Page<News>) newsMapper.selectByExampleWithBLOBs(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void favorite(Integer nid, Integer uid) {
        //添加到收藏表
        Favorites favorite = new Favorites(nid, uid);
        favoritesMapper.insert(favorite);
        //新闻被收藏+1
        News news = newsMapper.selectByPrimaryKey(nid);
        news.setFavoriteCount(news.getFavoriteCount() + 1);
        newsMapper.updateByPrimaryKey(news);
    }

    @Override
    public void removeFavorite(Integer nid, Integer uid) {
        //从收藏表删除
        FavoritesExample example = new FavoritesExample();
        FavoritesExample.Criteria criteria = example.createCriteria();
        criteria.andNidEqualTo(nid);
        criteria.andUidEqualTo(uid);
        favoritesMapper.deleteByExample(example);
        //新闻收藏量-1
        News news = newsMapper.selectByPrimaryKey(nid);
        news.setFavoriteCount(news.getFavoriteCount() - 1);
        newsMapper.updateByPrimaryKey(news);
    }

    @Override
    public boolean isFavorite(Integer nid, Integer uid) {
        if(uid == -1)
            //未登录
            return false;
        //查询数据库是否存在该记录
        FavoritesExample example = new FavoritesExample();
        FavoritesExample.Criteria criteria = example.createCriteria();
        criteria.andNidEqualTo(nid);
        criteria.andUidEqualTo(uid);
        List<Favorites> favorites = favoritesMapper.selectByExample(example);
        if (favorites.size() > 0)
            return true;
        return false;
    }

    @Override
    public void insertNews(News news) {
        //设置发布时间
        news.setReleaseDate(new Date());
        news.setFavoriteCount(0);
        news.setVisitCount(0);
        news.setCommentCount(0);
        if("".equals(news.getSource())){
            //原创
            news.setSource("../pages/details.html#?id="+news.getId());
        }
        newsMapper.insert(news);
    }

    @Override
    public News findByNid(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
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
        FastDFSClient fastDFSClient = new FastDFSClient("classpath:fast_dfs/fast_dfs_client.conf");

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


        //删除该新闻的评论
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria commentExampleCriteria = commentExample.createCriteria();
        commentExampleCriteria.andNidEqualTo(id);
        commentMapper.deleteByExample(commentExample);
        System.out.println("评论删除完毕");

        //删除该新闻
        newsMapper.deleteByPrimaryKey(id);
        System.out.print(new Date() + " : ");
        System.out.println("已删除新闻id:" + news.getId() + ",标题 : " + news.getTitle());
    }


    @Override
    public void update(News news) {
        if("".equals(news.getSource())){
            //原创
            news.setSource("../pages/details.html#?id="+news.getId());
        }
        newsMapper.updateByPrimaryKeySelective(news);
    }


}
