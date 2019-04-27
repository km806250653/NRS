package cn.hncu.pojo_group;

import cn.hncu.pojo.Comment;
import cn.hncu.pojo.Userinfo;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/16.
 */
public class CommUserGroup {
    private Comment comment;
    private Userinfo user;
    private boolean isLike;
    private List<CommUserGroup> children;



    public CommUserGroup() {
    }

    public CommUserGroup(Comment comment, Userinfo user) {
        this.comment = comment;
        this.user = user;
    }

    public CommUserGroup(Comment comment, Userinfo user, boolean isLike, List<CommUserGroup> children) {
        this.comment = comment;
        this.user = user;
        this.isLike = isLike;
        this.children = children;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public List<CommUserGroup> getChildren() {
        return children;
    }

    public void setChildren(List<CommUserGroup> children) {
        this.children = children;
    }
    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Userinfo getUser() {
        return user;
    }

    public void setUser(Userinfo user) {
        this.user = user;
    }
}
