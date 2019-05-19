package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.entity.Result;
import cn.hncu.pojo.Category;
import cn.hncu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/5/15.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/findPage")
    public PageResult findPage(int currentPage,int pageSize,String keywords){
        PageResult page = categoryService.findPage(currentPage, pageSize,keywords);
        return page;
    }

    @RequestMapping("/findAll")
    public List<Category> findAll(){

        return categoryService.findAll();
    }

    @RequestMapping("/findOne")
    public Category findOne(Integer id){
        return categoryService.findOne(id);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Category category){
        try {
            categoryService.add(category);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失败");
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Category category){
        try {
            categoryService.update(category);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer[] ids){
        try {
            categoryService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
