package cn.hncu.service;

import cn.hncu.pojo.News;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface INewsService {



    News findOne(Integer id);

    Integer insert(News news);

    List<News> findListByCid(Integer cid);
}
