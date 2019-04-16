package cn.hncu.service.impl;

import cn.hncu.pojo.Userinfo;
import cn.hncu.mapper.UserinfoMapper;
import cn.hncu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserinfoMapper userMapper;
    @Override
    public void register(Userinfo user) {
        userMapper.insert(user);
    }
}
