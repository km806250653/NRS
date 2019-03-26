package cn.hncu.service.impl;

import cn.hncu.domain.Category;
import cn.hncu.mapper.CategoryMapper;
import cn.hncu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(null);
    }
}
