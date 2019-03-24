package cn.hncu.service;

import cn.hncu.domain.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface INewsService {

    @Select("select * from news where cid=#{cid}")
    List<News> findByCid(Integer cid);

    @Select("select * from news")
    List<News> findAll();

    News findOne(Integer id);
}
