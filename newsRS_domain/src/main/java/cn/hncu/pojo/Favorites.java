package cn.hncu.pojo;

public class Favorites {
    private Integer id;

    private Integer nid;

    private Integer uid;

    public Favorites(Integer nid, Integer uid) {
        this.nid = nid;
        this.uid = uid;
    }

    public Favorites() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}