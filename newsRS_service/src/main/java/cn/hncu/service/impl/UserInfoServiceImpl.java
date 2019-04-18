package cn.hncu.service.impl;

import cn.hncu.pojo.Userinfo;
import cn.hncu.mapper.UserinfoMapper;
import cn.hncu.pojo.UserinfoExample;
import cn.hncu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

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
}
