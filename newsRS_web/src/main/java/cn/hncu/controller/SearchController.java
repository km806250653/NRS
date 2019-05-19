package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.NewsForSolr;
import cn.hncu.service.ISolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/5/12.
 */
@RestController
public class SearchController {

    @Autowired
    private ISolrService solrService;

    @RequestMapping("/search")
    public PageResult search(String keywords,int currentPage,int pageSize){
            return solrService.search(keywords,currentPage,pageSize);
    }

    @RequestMapping("/findBox")
    public List<NewsForSolr> findBox(){
        return solrService.findBox();
    }
}
