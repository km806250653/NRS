package cn.hncu.service;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.Category;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface ICategoryService {
    List<Category> findSome(String type);

    PageResult findPage(int currentPage, int pageSize,String keywords);

    Category findOne(Integer id);

    void add(Category category);

    void update(Category category);

    void delete(Integer[] ids);

    List<Category> findAll();
}
