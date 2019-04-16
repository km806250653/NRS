package cn.hncu.controller;

import cn.hncu.pojo_group.CommUserGroup;
import cn.hncu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
