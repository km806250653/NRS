package cn.hncu.controller;

import cn.hncu.utils.Spider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;

/**
 * Created by Enzo Cotter on 2019/3/24.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/testpath")
    public void testpath(HttpServletRequest request){
        URL path = Spider.class.getResource("/");
        String path1 = path.getPath();
        System.out.println(path1);
        String path2 = request.getContextPath();
        String path3 = request.getSession().getServletContext().getRealPath("/");//D:\javaEE\newsRS\newsRS_web\src\main\webapp\
        System.out.println(path3);
        path2 = path2 + "/img/news/test";
        path1 = path1 + "img/news/test";
        path3 = path3 + "img\\news\\test";
        System.out.println(path1);
        System.out.println(path2);
        File file = new File(path2);
        File file1 = new File(path1);
        File file3 = new File(path3);
        file.mkdirs();
        file1.mkdirs();
        file3.mkdirs();
    }
}
