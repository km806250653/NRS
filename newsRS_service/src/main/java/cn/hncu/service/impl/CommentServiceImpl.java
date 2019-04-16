package cn.hncu.service.impl;

import cn.hncu.mapper.CommentMapper;
import cn.hncu.mapper.UserinfoMapper;
import cn.hncu.pojo.Comment;
import cn.hncu.pojo.CommentExample;
import cn.hncu.pojo.Userinfo;
import cn.hncu.pojo_group.CommUserGroup;
import cn.hncu.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/16.
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserinfoMapper userMapper;
    @Override
    public List<CommUserGroup> findByNid(Integer nid) {
        ArrayList<CommUserGroup> list = new ArrayList<>();
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andNidEqualTo(nid);
        List<Comment> comments = commentMapper.selectByExample(example);
        comments.forEach(comment -> {
            Userinfo user = userMapper.selectByPrimaryKey(comment.getUid());
            list.add(new CommUserGroup(comment,user));
        });
        return list;
    }
}
