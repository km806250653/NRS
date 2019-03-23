package cn.hncu.mapper;

import cn.hncu.domain.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface INewsMapper {
    List<News> findByCid(Integer cid);
}
