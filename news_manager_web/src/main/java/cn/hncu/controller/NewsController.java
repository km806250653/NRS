package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.entity.Result;
import cn.hncu.pojo.Examine;
import cn.hncu.pojo.Manager;
import cn.hncu.pojo.News;
import cn.hncu.service.ExamineService;
import cn.hncu.service.INewsService;
import cn.hncu.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Enzo Cotter on 2019/5/16.
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ExamineService examineService;

    @RequestMapping("/findPage")
    public PageResult findPage(int currentPage, int pageSize,Integer cid, String keywords,String type){
        PageResult page = newsService.findPage(currentPage, pageSize,cid,keywords,type);
        return page;
    }

    @RequestMapping("/updateStatus")
    public Result updateStatus(@RequestBody Examine examine,int status){
        try {
            //更新该新闻的状态
            newsService.updateStatus(examine.getNid(),status);
            //设置操作的管理员id
            String managerName = SecurityContextHolder.getContext().getAuthentication().getName();
            Manager manager = managerService.findByUsername(managerName);
            examine.setMid(manager.getId());
            examineService.insert(examine);
            return new Result(true,"更新状态成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新状态失败");
        }
    }

    @RequestMapping("/updateStatusMultiple")
    public Result updateStatusMultiple(Integer[] nids ,int status,String content){
        String[] statusArr = {null,"审核通过","驳回",null,"删除"};
        try {
            Examine examine = new Examine();
            //设置操作的管理员id
            String managerName = SecurityContextHolder.getContext().getAuthentication().getName();
            Manager manager = managerService.findByUsername(managerName);
            examine.setMid(manager.getId());
            examine.setOperation(statusArr[status]);
            examine.setContent(content);
            for (Integer nid : nids) {
                newsService.updateStatus(nid,status);
                examine.setNid(nid);
                examineService.insert(examine);
            }
            return new Result(true,"批量审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"批量审核失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer[] ids){
        try {
            for (Integer id : ids) {
                newsService.deleById(id);
            }
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/examine")
    public Map examine(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        News news = newsService.findOne(id);
        map.put("news",news);
        List<Examine> examineList = examineService.findByNid(id);
        map.put("examines",examineList);
        return map;
    }


}
