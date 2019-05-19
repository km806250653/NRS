package cn.hncu.service.impl;

import cn.hncu.entity.PageResult;
import cn.hncu.mapper.ManagerMapper;
import cn.hncu.pojo.Manager;
import cn.hncu.pojo.ManagerExample;
import cn.hncu.pojo.Userinfo;
import cn.hncu.pojo.UserinfoExample;
import cn.hncu.service.ManagerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/5/14.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Manager findByUsername(String username) {
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Manager> managers = managerMapper.selectByExample(example);
        if (managers.size() > 0)
            return managers.get(0);
        return null;
    }

    @Override
    public PageResult findPage(int currentPage, int pageSize, String keywords) {
        PageHelper.offsetPage((currentPage-1)*pageSize,pageSize);
        ManagerExample example = new ManagerExample();
        if(!"".equals(keywords)){
            ManagerExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameLike("%"+keywords+"%");
        }
        Page<Manager> page = (Page<Manager>)managerMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Manager findOne(Integer id) {
        return managerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Manager manager) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        managerMapper.insert(manager);
    }

    @Override
    public void delete(Integer id) {
        managerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Manager manager) {
        managerMapper.updateByPrimaryKeySelective(manager);
    }
}
