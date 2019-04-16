package cn.hncu.controller;

import cn.hncu.pojo.News;
import cn.hncu.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;


    @RequestMapping("/findList")
    public @ResponseBody List<News> findList(Integer cid){
        return newsService.findListByCid(cid);
    }




    @RequestMapping("/findOne")
    public ModelAndView findOne(ModelAndView mv,Integer id){
        News news = newsService.findOne(id);
        System.out.println(news);
        mv.addObject("news",news);
        mv.setViewName("details");
        return mv;
    }
}
