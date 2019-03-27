package cn.hncu.service;

import cn.hncu.domain.News;
import cn.hncu.entity.ResultInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface INewsService {

    ResultInfo findList(Integer cid, String condition, int page, int size);

    List<News> findAll();

    News findOne(Integer id);

    Integer insert(News news);
}
