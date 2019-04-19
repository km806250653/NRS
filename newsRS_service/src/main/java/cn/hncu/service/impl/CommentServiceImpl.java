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
import java.util.Date;
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
        criteria.andParentIdIsNull();
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(example);
        comments.forEach(comment -> {
            Userinfo user = userMapper.selectByPrimaryKey(comment.getUid());
            CommUserGroup commUserGroup = new CommUserGroup(comment, user);
            commUserGroup.setChildren(findByParentId(comment.getId()));
            list.add(commUserGroup);
        });
        return list;
    }

    @Override
    public List<CommUserGroup> findByParentId(Integer pid) {
        ArrayList<CommUserGroup> list = new ArrayList<>();
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);
        List<Comment> children = commentMapper.selectByExampleWithBLOBs(example);
        children.forEach(child->{
            Userinfo user = userMapper.selectByPrimaryKey(child.getUid());
            list.add(new CommUserGroup(child,user));
        });
        return list;
    }

    @Override
    public void releaseComment(Comment comment) {
        comment.setReleaseTime(new Date());
        commentMapper.insert(comment);
    }

}
