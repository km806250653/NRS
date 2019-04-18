package cn.hncu.controller;

import cn.hncu.pojo.Category;
import cn.hncu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    @ResponseBody
    public List<Category> findAll(HttpServletRequest request,String type) {
        List<Category> categories = categoryService.findAll(type);
        return categories;
    }
}
