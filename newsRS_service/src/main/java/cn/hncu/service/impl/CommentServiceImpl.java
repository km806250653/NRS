package cn.hncu.service.impl;

import cn.hncu.entity.PageResult;
import cn.hncu.mapper.CommentMapper;
import cn.hncu.mapper.LikesMapper;
import cn.hncu.mapper.NewsMapper;
import cn.hncu.mapper.UserinfoMapper;
import cn.hncu.pojo.*;
import cn.hncu.pojo_group.CommNewsGroup;
import cn.hncu.pojo_group.CommUserGroup;
import cn.hncu.service.ICommentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private LikesMapper likesMapper;

    /**
     *
     * @param nid  当前新闻ID
     * @param uid  当前登录用户ID，未登陆时前端传过来 -1
     * @return
     */
    @Override
    public List<CommUserGroup> findByNid(Integer nid, Integer uid) {
        ArrayList<CommUserGroup> list = new ArrayList<>();
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andNidEqualTo(nid);
        criteria.andParentIdIsNull();
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(example);
        comments.forEach(comment -> {
            Userinfo user = userMapper.selectByPrimaryKey(comment.getUid());
            CommUserGroup commUserGroup = new CommUserGroup(comment, user,isLike(comment.getId(),uid),findByParentId(comment.getId(),uid));
            list.add(commUserGroup);
        });
        return list;
    }

    @Override
    public List<CommUserGroup> findByParentId(Integer pid,Integer uid) {
        ArrayList<CommUserGroup> list = new ArrayList<>();
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);
        List<Comment> children = commentMapper.selectByExampleWithBLOBs(example);
        children.forEach(child -> {
            Userinfo user = userMapper.selectByPrimaryKey(child.getUid());
            list.add(new CommUserGroup(child, user,isLike(child.getId(),uid),null));
        });
        return list;
    }

    @Override
    public void releaseComment(Comment comment) {
        comment.setReleaseTime(new Date());
        //添加评论
        commentMapper.insert(comment);
        //对应的新闻的评论量+1
        //查询该新闻
        News news = newsMapper.selectByPrimaryKey(comment.getNid());
        //评论数+1
        news.setCommentCount(news.getCommentCount() + 1);
        //更新进数据库
        newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public PageResult findByUid(Integer uid, int pageNum) {
        ArrayList<CommNewsGroup> list = new ArrayList<>();
        PageHelper.startPage(pageNum, 4);
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("release_time desc");
        criteria.andUidEqualTo(uid);
        Page<Comment> page = (Page<Comment>) commentMapper.selectByExampleWithBLOBs(example);
        List<Comment> comments = page.getResult();
        comments.forEach(comment -> {
            News news = newsMapper.selectByPrimaryKey(comment.getNid());
            list.add(new CommNewsGroup(comment, news));
        });
        return new PageResult(page.getTotal(), list);
    }

    /**
     * 点赞
     *
     * @param commentId
     * @param uid
     */
    @Override
    public void like(Integer commentId, int uid) {
        //添加记录到点赞表
        Likes likes = new Likes(commentId, uid);
        likesMapper.insert(likes);
        //该评论点赞数+1
        Comment comment = commentMapper.selectByPrimaryKey(commentId);
        comment.setLikeCount(comment.getLikeCount() + 1);
        commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    public void removeLike(Integer commentId, int uid) {
        //从表中删除记录
        LikesExample example = new LikesExample();
        LikesExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(commentId);
        criteria.andUidEqualTo(uid);
        likesMapper.deleteByExample(example);
        //该评论点赞数-1
        Comment comment = commentMapper.selectByPrimaryKey(commentId);
        comment.setLikeCount(comment.getLikeCount() - 1);
        commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    public boolean isLike(Integer commentId, int uid) {
        if (uid == -1)
            //未登录
            return false;
        //从表中查询该记录
        LikesExample example = new LikesExample();
        LikesExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(commentId);
        criteria.andUidEqualTo(uid);
        List<Likes> likes = likesMapper.selectByExample(example);
        if (likes.size() > 0)
            return true;
        return false;
    }

}
