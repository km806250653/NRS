package cn.hncu.service;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.News;
import cn.hncu.pojo_group.NewsWithImages;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface INewsService {



    News findOne(Integer id);

    void insert(NewsWithImages newsWithImages);


    PageResult findListByCid(Integer cid, int pageNum, int pageSize);

    void deleById(Integer id) throws Exception;

    /**
     * 删除爬取的新闻
     */
    void deleCrawlNews() throws Exception;

    /**
     * 通过新闻来源判断新闻是否在数据库中存在
     * @param source
     * @return
     */
    boolean isExists(String source);

    void update(News news);

    PageResult findListByUid(Integer uid, int pageNum);

    void favorite(Integer nid, Integer uid);

    void removeFavorite(Integer nid, Integer uid);

    boolean isFavorite(Integer nid, Integer uid);

    void insertNews(News news);

    News findByNid(Integer id);

}
