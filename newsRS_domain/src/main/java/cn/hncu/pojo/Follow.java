package cn.hncu.pojo;

public class Follow {
    private Integer id;

    private Integer uid;

    private Integer followerId;

    public Follow(Integer uid, Integer followId) {
        this.uid = uid;
        this.followerId = followId;
    }

    public Follow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }
}