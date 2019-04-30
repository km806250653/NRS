package cn.hncu.controller;

import cn.hncu.pojo.Category;
import cn.hncu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/23.
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/findSome")
    public List<Category> findSome(String type) {
        List<Category> categories = categoryService.findSome(type);
        return categories;
    }

    @RequestMapping("/findAll")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

}
