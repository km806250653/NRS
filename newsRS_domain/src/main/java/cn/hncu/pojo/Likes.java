package cn.hncu.pojo;

public class Likes {
    private Integer id;

    private Integer cid;

    private Integer uid;

    public Likes(Integer cid, Integer uid) {
        this.cid = cid;
        this.uid = uid;
    }

    public Likes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}