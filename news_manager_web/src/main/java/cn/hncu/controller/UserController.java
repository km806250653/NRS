package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.Userinfo;
import cn.hncu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Enzo Cotter on 2019/5/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserInfoService userService;

    @RequestMapping("/findPage")
    public PageResult findPage(int currentPage, int pageSize,String keywords){
        PageResult page = userService.findPage(currentPage, pageSize,keywords);
        return page;
    }

    @RequestMapping("/findOne")
    public Userinfo findOne(Integer id){
        return userService.findOne(id);
    }
}
