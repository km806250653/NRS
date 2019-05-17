package cn.hncu.service;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.NewsForSolr;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/5/12.
 */
public interface ISolrService {
    PageResult search(String keywords,int currentPage,int pageSize);

    List<NewsForSolr> findBox();
}
