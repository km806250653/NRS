package cn.hncu.service.impl;

import cn.hncu.mapper.FollowMapper;
import cn.hncu.pojo.Follow;
import cn.hncu.pojo.FollowExample;
import cn.hncu.pojo.Userinfo;
import cn.hncu.mapper.UserinfoMapper;
import cn.hncu.pojo.UserinfoExample;
import cn.hncu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserinfoMapper userMapper;

    @Autowired
    private FollowMapper followMapper;

    @Override
    public void register(Userinfo user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userMapper.insert(user);
    }

    @Override
    public void update(Userinfo user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void update(String password) {

    }

    @Override
    public void follow(Integer uid, Integer followId) {
        //设置进关注表
        Follow follow = new Follow(uid, followId);
        followMapper.insert(follow);
        //设置被关注者
        Userinfo userFor = userMapper.selectByPrimaryKey(uid);
        //关注我的+1
        userFor.setFollower(userFor.getFollower()+1);
        userMapper.updateByPrimaryKeySelective(userFor);
        //设置关注者
        Userinfo userFrom = userMapper.selectByPrimaryKey(followId);
        //我关注的+1
        userFrom.setFollow(userFrom.getFollow()+1);
        userMapper.updateByPrimaryKeySelective(userFrom);
    }

    @Override
    public Userinfo getUserByUsername(String username) {
            UserinfoExample example = new UserinfoExample();
            UserinfoExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(username);
            return userMapper.selectByExample(example).get(0);
    }

    @Override
    public Userinfo getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Userinfo findCurrentUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean isExists(String username) {
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Userinfo> list = userMapper.selectByExample(example);
        return list.size()>0;
    }

    @Override
    public boolean isFollow(Integer uid, Integer followId) {
        FollowExample example = new FollowExample();
        FollowExample.Criteria criteria = example.createCriteria();
        //查询被关注者是当前用户且关注者是登录用户的记录
        criteria.andUidEqualTo(uid);
        criteria.andFollowerIdEqualTo(followId);
        List<Follow> list = followMapper.selectByExample(example);
        if(list.size()>0)
            return true;
        return false;
    }

    @Override
    public void removeFollow(Integer uid, Integer followId) {
        //从关注表中删除记录
        FollowExample example = new FollowExample();
        FollowExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andFollowerIdEqualTo(followId);
        followMapper.deleteByExample(example);
        //设置被关注者
        Userinfo userFor = userMapper.selectByPrimaryKey(uid);
        //关注我的-1
        userFor.setFollower(userFor.getFollower()-1);
        userMapper.updateByPrimaryKeySelective(userFor);
        //设置关注者
        Userinfo userFrom = userMapper.selectByPrimaryKey(followId);
        //我关注的-1
        userFrom.setFollow(userFrom.getFollow()-1);
        userMapper.updateByPrimaryKeySelective(userFrom);

    }
}
