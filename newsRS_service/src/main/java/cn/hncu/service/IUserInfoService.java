package cn.hncu.service;

import cn.hncu.pojo.Userinfo;

import java.util.Map;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public interface IUserInfoService {
    public void register(Userinfo user);

    public Userinfo getUserByUsername(String username);

    Map<String,Object> findCurrentUser(Integer id);

    boolean isExists(String username);
}
