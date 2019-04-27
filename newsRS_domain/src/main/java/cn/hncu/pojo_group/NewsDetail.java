package cn.hncu.pojo_group;

import cn.hncu.pojo.News;
import cn.hncu.pojo.Userinfo;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/22.
 */
public class NewsDetail {
    private News news;
    private List comments;
    private Userinfo user;

    //该文章是否被当前登录用户收藏
    private Boolean isFavorite;





    public NewsDetail() {
    }

    public NewsDetail(News news, List comments,Userinfo user) {
        this.news = news;
        this.comments = comments;
        this.user = user;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public Userinfo getUser() {
        return user;
    }

    public void setUser(Userinfo user) {
        this.user = user;
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
