package cn.hncu.pojo_group;

import cn.hncu.pojo.Comment;
import cn.hncu.pojo.News;

/**
 * 查询评论和它所属的新闻，此时可看作一对一
 * Created by Enzo Cotter on 2019/4/26.
 */
public class CommNewsGroup {
    private Comment comment;
    private News news;

    public CommNewsGroup() {
    }

    public CommNewsGroup(Comment comment, News news) {
        this.comment = comment;
        this.news = news;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
