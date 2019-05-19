package cn.hncu.service;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.Manager;
import cn.hncu.pojo.Userinfo;

/**
 * Created by Enzo Cotter on 2019/5/14.
 */
public interface ManagerService {
    Manager findByUsername(String username);

    PageResult findPage(int currentPage, int pageSize, String keywords);

    Manager findOne(Integer id);

    void add(Manager manager);

    void delete(Integer id);

    void update(Manager manager);
}
