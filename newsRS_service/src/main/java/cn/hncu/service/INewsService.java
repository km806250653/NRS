package cn.hncu.service;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.News;
import cn.hncu.pojo_group.NewsWithImages;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface INewsService {



    News findOne(Integer id);

    PageResult findListByCid(Integer cid, int pageNum, int pageSize);

    void deleById(Integer id) throws Exception;


    void update(News news);

    PageResult findListByUid(Integer uid, int pageNum);

    void favorite(Integer nid, Integer uid);

    void removeFavorite(Integer nid, Integer uid);

    boolean isFavorite(Integer nid, Integer uid);

    void insertNews(News news);

    News findByNid(Integer id);

}
