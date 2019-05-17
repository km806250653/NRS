package cn.hncu.service.impl;

import cn.hncu.entity.PageResult;
import cn.hncu.mapper.CategoryMapper;
import cn.hncu.pojo.Category;
import cn.hncu.pojo.CategoryExample;
import cn.hncu.service.ICategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public List<Category> findSome(String type) {

        CategoryExample example = new CategoryExample();
        example.setOrderByClause("sort ASC");
        if(type.equals("more"))
            PageHelper.offsetPage(7,100000);
        else
            PageHelper.offsetPage(0,7);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public PageResult findPage(int currentPage, int pageSize,String keywords) {
        PageHelper.offsetPage((currentPage-1)*pageSize,pageSize);
        CategoryExample example = new CategoryExample();
        if(!"".equals(keywords)){
            CategoryExample.Criteria criteria = example.createCriteria();
            criteria.andTextLike("%"+keywords+"%");
        }
        Page<Category> page = (Page<Category>)categoryMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Category findOne(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Category> findAll() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("sort ASC");
        return categoryMapper.selectByExample(example);
    }
}
