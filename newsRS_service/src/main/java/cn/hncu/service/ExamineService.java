package cn.hncu.service;

import cn.hncu.pojo.Examine;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/5/18.
 */
public interface ExamineService {

    void insert(Examine examine);

    void delete(Integer id);

    List<Examine> findByNid(Integer nid);
}
