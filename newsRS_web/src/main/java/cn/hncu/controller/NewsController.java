package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.entity.Result;
import cn.hncu.pojo.Examine;
import cn.hncu.pojo.News;
import cn.hncu.pojo.Userinfo;
import cn.hncu.pojo_group.CommUserGroup;
import cn.hncu.pojo_group.NewsDetail;
import cn.hncu.pojo_group.NewsWithImages;
import cn.hncu.service.ExamineService;
import cn.hncu.service.ICommentService;
import cn.hncu.service.INewsService;
import cn.hncu.service.IUserInfoService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserInfoService userService;

    @Autowired
    private ExamineService examineService;

    @RequestMapping("/findHot")
    public Map<String,Object> findCover(){
        return newsService.findHot();
    }

    @RequestMapping("/findRank")
    public List<Map> findRank(){
        return newsService.findRank();
    }
    @RequestMapping("/findList")
    public PageResult findList(Integer cid, int pageNum, int pageSize) {

        return newsService.findListByCid(cid, pageNum, pageSize);
    }

    @RequestMapping("/findOne")
    public News findOne(Integer id) {

        return newsService.findByNid(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody News news) {
        try {
            newsService.update(news);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            return new Result(false,"修改失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer id) {
        try {
            newsService.deleById(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }


    @RequestMapping("/findListByUid")
    public PageResult findListByUid(Integer uid, Integer pageNum) {

        return newsService.findListByUid(uid, pageNum);
    }

    @RequestMapping("/findFavoriteByUid")
    public PageResult findFavoriteByUid(Integer uid, Integer pageNum) {

        return newsService.findFavoriteByUid(uid, pageNum);
    }
    @RequestMapping("/findExceptionNews")
    public List<News> findExceptionListByUid(Integer uid, Integer status) {
        return newsService.findExceptionListByUid(uid, status);
    }
    //查询审核详情
    @RequestMapping("/examine")
    public Map examine(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        News news = newsService.findOne(id);
        map.put("news",news);
        List<Examine> examineList = examineService.findByNid(id);
        map.put("examines",examineList);
        return map;
    }
    //提交审核
    @RequestMapping("/updateStatus")
    public Result updateStatus(Integer nid,String content){
        try {

            //更新该新闻的状态
            newsService.updateStatus(nid,3);
            //添加操作记录
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Userinfo user = userService.getUserByUsername(username);
            Examine examine = new Examine();
            examine.setUid(user.getId());
            examine.setNid(nid);
            examine.setContent(content);
            examine.setOperation("申请再次审核");
            examineService.insert(examine);
            return new Result(true,"更新状态成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"更新状态失败");
    }

    @RequestMapping("/insert")
    public Result insertNews(@RequestBody News news) {
        try {
            newsService.insertNews(news);
            return new Result(true, "发布成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发布失败");
        }
    }
    @RequestMapping("/favorite")
    public Result favorite(Integer nid, Integer uid) {
        try {
            newsService.favorite(nid, uid);
            return new Result(true, "收藏成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "收藏失败");
        }
    }

    @RequestMapping("/removeFavorite")
    public Result removeFavorite(Integer nid, Integer uid) {
        try {
            newsService.removeFavorite(nid, uid);
            return new Result(true, "取消收藏成功");
        } catch (Exception e) {
            return new Result(false, "取消收藏失败");
        }
    }



    @RequestMapping("/findDetail")
    public NewsDetail findOne(Integer nid, Integer uid) throws IOException, SolrServerException {
        NewsDetail newsDetail = new NewsDetail();
        News news = newsService.findOne(nid);
        //访问量+1
        news.setVisitCount(news.getVisitCount() + 1);
        //更新到数据库
        newsService.update(news);
        //设置进组合对象
        newsDetail.setNews(news);
        //查询发布者信息
        Userinfo user = userService.getUserById(news.getUid());
        newsDetail.setUser(user);
        //查询该新闻的全部评论
        List<CommUserGroup> comments = commentService.findByNid(nid, uid);
        newsDetail.setComments(comments);
        //是否已被当前用户收藏
        boolean isFavorite = newsService.isFavorite(nid, uid);
        newsDetail.setFavorite(isFavorite);
        return newsDetail;
    }
}
