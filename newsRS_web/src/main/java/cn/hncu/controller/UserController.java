package cn.hncu.controller;

import cn.hncu.entity.ResultInfo;
import cn.hncu.pojo.Userinfo;
import cn.hncu.entity.Result;
import cn.hncu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Enzo Cotter on 2019/4/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserInfoService userService;

    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestBody Userinfo user) {
        try {
            userService.register(user);
            return new Result(true, "注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "注册失败");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Userinfo user) {
        try {
            userService.update(user);
            return new Result(true, "注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "注册失败");
        }
    }

    @RequestMapping("/follow")
    @ResponseBody
    public Result follow(Integer uid, Integer followId) {
        try {
            userService.follow(uid, followId);
            return new Result(true, "关注成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "关注失败");
        }
    }

    @RequestMapping("/removeFollow")
    @ResponseBody
    public Result removeFollow(Integer uid, Integer followId) {
        try {
            userService.removeFollow(uid, followId);
            return new Result(true, "关注成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "关注失败");
        }
    }

    @RequestMapping("/isFollow")
    @ResponseBody
    public Result isFollow(Integer uid, Integer followId) {
        if (userService.isFollow(uid, followId))
            return new Result(true, "已关注！");
        return new Result(false, "未关注");
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public ResultInfo findUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
        if (name != null && !"".equals(name) && !"anonymousUser".equals(name))
            return new ResultInfo(userService.getUserByUsername(name), true, "获取成功");
        else
            return new ResultInfo(null, false, "获取失败");
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mv) {
        mv.setViewName("own_page");
        return mv;
    }

    @RequestMapping("/findCurrentUser")
    @ResponseBody
    public Userinfo findCurrentUser(Integer id) {

        return userService.findCurrentUser(id);
    }

    @RequestMapping("/isExists")
    @ResponseBody
    public Result isExists(String username) {
        if (userService.isExists(username)) {
            //存在
            return new Result(false, "用户名已存在");
        } else {
            //不存在
            return new Result(true, "用户名可以使用");
        }
    }

}