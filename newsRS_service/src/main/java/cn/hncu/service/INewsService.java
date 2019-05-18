package cn.hncu.service;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.News;
import cn.hncu.pojo_group.NewsWithImages;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface INewsService {



    News findOne(Integer id);

    PageResult findListByCid(Integer cid, int pageNum, int pageSize);

    void deleById(Integer id) throws Exception;


    void update(News news) throws IOException, SolrServerException;

    PageResult findListByUid(Integer uid, int pageNum);

    void favorite(Integer nid, Integer uid) throws IOException, SolrServerException;

    void removeFavorite(Integer nid, Integer uid) throws IOException, SolrServerException;

    boolean isFavorite(Integer nid, Integer uid);

    void insertNews(News news) throws IOException, SolrServerException;

    News findByNid(Integer id);

    Map<String,Object> findHot();

    List<Map> findRank();

    PageResult findPage(int currentPage, int pageSize,Integer cid, String keywords,String type);

    void updateStatus(Integer id, int status);
}
