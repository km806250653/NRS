package cn.hncu.service;

import cn.hncu.entity.PageResult;
import cn.hncu.pojo.Comment;
import cn.hncu.pojo_group.CommNewsGroup;
import cn.hncu.pojo_group.CommUserGroup;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/16.
 */
public interface ICommentService {
    List<CommUserGroup> findByNid(Integer nid,Integer uid);

    List<CommUserGroup> findByParentId(Integer pid,Integer uid);

    void releaseComment(Comment comment);

    PageResult findByUid(Integer uid, int pageNum);

    void like(Integer commentId, int uid);

    void removeLike(Integer commentId, int uid);

    boolean isLike(Integer commentId, int uid);
}
