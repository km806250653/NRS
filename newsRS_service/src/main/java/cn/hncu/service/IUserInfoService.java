package cn.hncu.service;

import cn.hncu.pojo.Userinfo;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface IUserInfoService {
    public void register(Userinfo user);

    public void update(Userinfo user);

    public void update(String password);

    public void follow(Integer uid,Integer followId);

    public Userinfo getUserByUsername(String username);

    public Userinfo getUserById(Integer id);

    Userinfo findCurrentUser(Integer id);

    boolean isExists(String username);

    boolean isFollow(Integer uid, Integer followId);

    void removeFollow(Integer uid, Integer followId);
}
