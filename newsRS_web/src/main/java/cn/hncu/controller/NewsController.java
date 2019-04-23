package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.News;
import cn.hncu.pojo_group.CommUserGroup;
import cn.hncu.pojo_group.NewsWithComm;
import cn.hncu.service.ICommentService;
import cn.hncu.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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


    @RequestMapping("/findList")
    public PageResult findList(Integer cid,int pageNum,int pageSize) {

        return newsService.findListByCid(cid,pageNum,pageSize);
    }


    @RequestMapping("/findOne")
    public NewsWithComm findOne(Integer id) {
        NewsWithComm newsWithComm = new NewsWithComm();
        News news = newsService.findOne(id);
        newsWithComm.setNews(news);
        List<CommUserGroup> comments = commentService.findByNid(id);
        newsWithComm.setComments(comments);
        return newsWithComm;
    }
}
