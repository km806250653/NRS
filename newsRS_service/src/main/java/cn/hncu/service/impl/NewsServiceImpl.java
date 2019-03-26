package cn.hncu.service.impl;

import cn.hncu.domain.News;
import cn.hncu.domain.NewsExample;
import cn.hncu.mapper.NewsMapper;
import cn.hncu.service.INewsService;
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
    public List<News> findByCid(Integer cid) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        return newsMapper.selectByExample(example);
    }

    @Override
    public List<News> findAll() {
        return newsMapper.selectByExample(null);
    }

    @Override
    public News findOne(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
