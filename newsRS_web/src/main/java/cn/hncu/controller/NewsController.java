package cn.hncu.controller;

import cn.hncu.domain.News;
import cn.hncu.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @RequestMapping("/findAll")
    public @ResponseBody List<News> findBycid(int cid){
        List<News> list = newsService.findBycid(cid);
        return list;
    }
}
