package cn.hncu.controller;

import cn.hncu.entity.Result;
import cn.hncu.pojo.Comment;
import cn.hncu.pojo_group.CommUserGroup;
import cn.hncu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/16.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @RequestMapping("/findByNid")
    public List<CommUserGroup> findByNid(Integer nid){
        return commentService.findByNid(nid);
    }

    @RequestMapping("/releaseComment")
    public Result releaseComment(@RequestBody Comment comment){
        System.out.println(comment);
        try {
            commentService.releaseComment(comment);
            return new Result(true,"评论成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"评论出现错误");
        }
    }
}
