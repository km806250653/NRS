package cn.hncu.mapper;

import cn.hncu.domain.Category;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface ICategoryMapper {
    List<Category> findAll();
}
