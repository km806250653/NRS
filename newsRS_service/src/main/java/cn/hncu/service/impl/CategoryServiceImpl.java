package cn.hncu.service.impl;

import cn.hncu.pojo.Category;
import cn.hncu.pojo.CategoryExample;
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
    public List<Category> findAll(String type) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        if(type.equals("more"))
        criteria.andIdGreaterThanOrEqualTo(7);
        else
            criteria.andIdLessThanOrEqualTo(6);
        return categoryMapper.selectByExample(example);
    }
}
