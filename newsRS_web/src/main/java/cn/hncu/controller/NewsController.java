package cn.hncu.controller;

import cn.hncu.domain.News;
import cn.hncu.entity.ResultInfo;
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

    @RequestMapping("/findAll")
    public @ResponseBody List<News> findAll(){
        List<News> list = newsService.findAll();
        return list;
    }

    @RequestMapping("/findList")
    public ModelAndView findList(ModelAndView mv,Integer cid,String condition,Integer currentPage,Integer size){
        ResultInfo result = newsService.findList(cid,condition,currentPage,size);
        result.setCurrentPage(currentPage);
        mv.addObject("result",result);
        mv.setViewName("news_list");
        return mv;
    }

    @RequestMapping("/findaaa")
    public @ResponseBody ResultInfo findaaa(){
        ResultInfo result = newsService.findList(1,"人民",1,5);
        return result;
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
