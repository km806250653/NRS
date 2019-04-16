package cn.hncu.service;

import cn.hncu.pojo.Comment;
import cn.hncu.pojo_group.CommUserGroup;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/16.
 */
public interface ICommentService {
    public List<CommUserGroup> findByNid(Integer nid);
}
