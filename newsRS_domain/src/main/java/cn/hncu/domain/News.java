package cn.hncu.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public class News implements Serializable {

    private Integer id;         //唯一标志，无意义
    private String title;       //新闻标题
    private String author;      //作者
    private Date releaseDate;   //发布时间
    private String content;     //正文内容
    private String Source;      //源地址
    private Integer cid;        //所属类别
    private Integer uid;        //上传用户id

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", content='" + content + '\'' +
                ", Source='" + Source + '\'' +
                ", cid=" + cid +
                ", uid=" + uid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
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
