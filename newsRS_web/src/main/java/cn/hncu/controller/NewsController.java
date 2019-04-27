package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.entity.Result;
import cn.hncu.pojo.News;
import cn.hncu.pojo.Userinfo;
import cn.hncu.pojo_group.CommUserGroup;
import cn.hncu.pojo_group.NewsDetail;
import cn.hncu.service.ICommentService;
import cn.hncu.service.INewsService;
import cn.hncu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserInfoService userService;

    @RequestMapping("/findList")
    public PageResult findList(Integer cid, int pageNum, int pageSize) {

        return newsService.findListByCid(cid, pageNum, pageSize);
    }

    @RequestMapping("/findListByUid")
    public PageResult findListByUid(Integer uid, Integer pageNum) {
        return newsService.findListByUid(uid, pageNum);
    }

    @RequestMapping("/favorite")
    public Result favorite(Integer nid, Integer uid) {
        try {
            newsService.favorite(nid, uid);
            return new Result(true, "收藏成功");
        } catch (Exception e) {
            return new Result(false, "收藏失败");
        }
    }

    @RequestMapping("/removeFavorite")
    public Result removeFavorite(Integer nid, Integer uid) {
        try {
            newsService.removeFavorite(nid, uid);
            return new Result(true, "取消收藏成功");
        } catch (Exception e) {
            return new Result(false, "取消收藏失败");
        }
    }



    @RequestMapping("/findOne")
    public NewsDetail findOne(Integer nid, Integer uid) {
        NewsDetail newsDetail = new NewsDetail();
        News news = newsService.findOne(nid);
        //访问量+1
        news.setVisitCount(news.getVisitCount() + 1);
        //更新到数据库
        newsService.update(news);
        //设置进组合对象
        newsDetail.setNews(news);
        //查询发布者信息
        Userinfo user = userService.getUserById(news.getUid());
        newsDetail.setUser(user);
        //查询该新闻的全部评论
        List<CommUserGroup> comments = commentService.findByNid(nid, uid);
        newsDetail.setComments(comments);
        //是否已被当前用户收藏
        boolean isFavorite = newsService.isFavorite(nid, uid);
        System.out.println(nid+"************"+uid);
        System.out.println(isFavorite);
        newsDetail.setFavorite(isFavorite);

        return newsDetail;
    }
}
