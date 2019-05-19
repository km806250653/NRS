package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.entity.Result;
import cn.hncu.pojo.Manager;
import cn.hncu.pojo.Userinfo;
import cn.hncu.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Enzo Cotter on 2019/5/16.
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/findPage")
    public PageResult findPage(int currentPage, int pageSize, String keywords){
        PageResult page = managerService.findPage(currentPage, pageSize,keywords);
        return page;
    }

    @RequestMapping("/findOne")
    public Manager findOne(Integer id){
        return managerService.findOne(id);
    }

    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            managerService.delete(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Manager manager){
        try {
            managerService.add(manager);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/getUser")
    public Manager getCurrentManager(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Manager manager = managerService.findByUsername(name);
        return manager;
    }

    @RequestMapping("/updatePassword")
    public Result updatePassword(Integer id ,String oldPassword,String newPassword){
        try {
            //查找该用户
            Manager manager = managerService.findOne(id);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //判断旧密码是否输入正确

            if(!encoder.matches(oldPassword,manager.getPassword())){
                return new Result(false,"原密码错误");
            }
            manager.setPassword(encoder.encode(newPassword));
            managerService.update(manager);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }
}
