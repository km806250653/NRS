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
    public List<News> findBycid(Integer cid) {
        return newsMapper.findBycid(cid);
    }
}
