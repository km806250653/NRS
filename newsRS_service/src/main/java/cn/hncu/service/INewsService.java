package cn.hncu.service;

import cn.hncu.domain.News;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface INewsService {

    List<News> findBycid(Integer cid);

}
