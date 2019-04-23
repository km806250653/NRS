package cn.hncu.service.impl;

import cn.hncu.pojo.Userinfo;
import cn.hncu.mapper.UserinfoMapper;
import cn.hncu.pojo.UserinfoExample;
import cn.hncu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserinfoMapper userMapper;
    @Override
    public void register(Userinfo user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userMapper.insert(user);
    }

    @Override
    public Userinfo getUserByUsername(String username) {
            UserinfoExample example = new UserinfoExample();
            UserinfoExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(username);
            return userMapper.selectByExample(example).get(0);
    }

    @Override
    public Map<String, Object> findCurrentUser(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        Userinfo user = userMapper.selectByPrimaryKey(id);
        map.put("user",user);
        return map;
    }

    @Override
    public boolean isExists(String username) {
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Userinfo> list = userMapper.selectByExample(example);
        return list.size()>0;
    }
}
