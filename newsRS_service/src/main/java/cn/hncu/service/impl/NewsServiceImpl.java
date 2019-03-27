package cn.hncu.service.impl;

import cn.hncu.domain.News;
import cn.hncu.domain.NewsExample;
import cn.hncu.entity.ResultInfo;
import cn.hncu.mapper.NewsMapper;
import cn.hncu.service.INewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;


    @Override
    public ResultInfo findList(Integer cid, String condition, int currentPage, int size) {
        //分页
        PageHelper.startPage(currentPage,size);
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        //类别
        criteria.andCidEqualTo(cid);
        //条件
        if (condition != null && !condition.equals("null") && condition.length() > 0)
            criteria.andTitleLike("%" + condition + "%");
        Page<News> pageNews = (Page<News>) newsMapper.selectByExample(example);
        return new ResultInfo(pageNews.getResult(),pageNews.getTotal());
    }

    @Override
    public List<News> findAll() {
        return newsMapper.selectByExample(null);
    }

    @Override
    public News findOne(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer insert(News news) {
        Integer insert = newsMapper.insert(news);
        return insert;
    }
}
