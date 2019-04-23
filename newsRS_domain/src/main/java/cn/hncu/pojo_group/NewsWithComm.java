package cn.hncu.pojo_group;

import cn.hncu.pojo.News;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/22.
 */
public class NewsWithComm {
    private News news;
    private List comments;

    public NewsWithComm() {
    }

    public NewsWithComm(News news, List comments) {
        this.news = news;
        this.comments = comments;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List getComments() {
        return comments;
    }

    public void setComments(List comments) {
        this.comments = comments;
    }
}
