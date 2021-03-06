package cn.hncu.controller;

import cn.hncu.domain.Category;
import cn.hncu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/3/23.
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/findAll")
    public @ResponseBody List<Category> findAll(){
        List<Category> categories = categoryService.findAll();

        return categories;
    }
}
