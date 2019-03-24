package cn.hncu.service.impl;

import cn.hncu.domain.News;
import cn.hncu.mapper.INewsMapper;
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
    private INewsMapper newsMapper;


    @Override
    public List<News> findByCid(Integer cid) {
        return newsMapper.findByCid(cid);
    }

    @Override
    public List<News> findAll() {
        return newsMapper.findAll();
    }

    @Override
    public News findOne(Integer id) {
        return newsMapper.findOne(id);
    }
}
