package cn.hncu.controller;

import cn.hncu.entity.PageResult;
import cn.hncu.entity.Result;
import cn.hncu.pojo.Comment;
import cn.hncu.pojo_group.CommNewsGroup;
import cn.hncu.pojo_group.CommUserGroup;
import cn.hncu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/16.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;



    @RequestMapping("/findByUid")
    public PageResult findByUid(Integer uid, int pageNum) {
        return commentService.findByUid(uid, pageNum);
    }

    @RequestMapping("/like")
    public Result like(Integer commentId, int uid) {
        try {
            commentService.like(commentId, uid);
            return new Result(true, "点赞成功");
        } catch (Exception e) {
            return new Result(false, "点赞失败");
        }
    }

    @RequestMapping("/removeLike")
    public Result removeLike(Integer commentId, int uid) {
        try {
            commentService.removeLike(commentId, uid);
            return new Result(true, "取消点赞成功");
        } catch (Exception e) {
            return new Result(false, "取消点赞失败");
        }
    }


    @RequestMapping("/releaseComment")
    public Result releaseComment(@RequestBody Comment comment) {
        try {
            commentService.releaseComment(comment);
            return new Result(true, "评论成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "评论出现错误");
        }
    }

    @RequestMapping("/delete")
    public Result deleteComment(Integer id) {
        try {
            commentService.delete(id);
            return new Result(true, "删除评论成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除评论失败");
        }
    }

}
