package cn.hncu.service;

import cn.hncu.domain.Category;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface ICategoryService {
    List<Category> findAll();
}
