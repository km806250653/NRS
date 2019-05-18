package cn.hncu.service.impl;

import cn.hncu.mapper.ExamineMapper;
import cn.hncu.pojo.Examine;
import cn.hncu.pojo.ExamineExample;
import cn.hncu.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/5/18.
 */
@Service
public class ExamineServiceImpl implements ExamineService {

    @Autowired
    private ExamineMapper examineMapper;
    @Override
    public void insert(Examine examine) {
        examineMapper.insert(examine);
    }

    @Override
    public void delete(Integer id) {
        examineMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Examine> findByNid(Integer nid) {
        ExamineExample example = new ExamineExample();
        ExamineExample.Criteria criteria = example.createCriteria();
        criteria.andNidEqualTo(nid);
        return examineMapper.selectByExampleWithBLOBs(example);
    }
}
