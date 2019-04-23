package cn.hncu.pojo;

import java.io.Serializable;

public class NewsImage implements Serializable {
    private Integer id;

    private Integer nid;

    private String url;

    public NewsImage(String url) {
        this.url = url;
    }

    public NewsImage(Integer id, Integer nid, String url) {
        this.id = id;
        this.nid = nid;
        this.url = url;
    }

    public NewsImage() {
    }

    @Override
    public String toString() {
        return "NewsImage{" +
                "id=" + id +
                ", nid=" + nid +
                ", url='" + url + '\'' +
                '}';
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}