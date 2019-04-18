package cn.hncu.controller;

import cn.hncu.pojo.Userinfo;
import cn.hncu.entity.Result;
import cn.hncu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public Result register(@RequestBody Userinfo user){
        try {
            userService.register(user);
            return new Result(true,"注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"注册失败");
        }
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Userinfo showName(){
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
            if(name!=null&&!"".equals(name)&&!"anonymousUser".equals(name))
            return userService.getUserByUsername(name);
            else
                return null;
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mv){
        mv.setViewName("index");
        return mv;
    }
}
