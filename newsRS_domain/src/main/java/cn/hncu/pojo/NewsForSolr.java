package cn.hncu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Enzo Cotter on 2019/5/12.
 */
public class NewsForSolr implements Serializable {
    @Field
    private Integer id;

    @Field("km_news_title")
    private String title;

    @Field("km_news_release_date")
    @JsonFormat(pattern = "yyyy,MM-dd hh:mm")
    private Date releaseDate;


    @Field("km_news_image")
    private String image;

    @Field("km_news_comment_count")
    private Integer commentCount;

    @Field("km_news_visit_count")
    private Integer visitCount;

    @Field("km_news_favorite_count")
    private Integer favoriteCount;

    @Field("km_news_content")
    private String content;

    @Field("km_category_text")
    private String category;


    public void setNews(News news){
        this.id = news.getId();
        this.releaseDate = news.getReleaseDate();
        this.title = news.getTitle();
        this.image = news.getImage();
        this.content = news.getContent();
        this.commentCount = news.getCommentCount();
        this.visitCount = news.getVisitCount();
        this.favoriteCount = news.getFavoriteCount();
    }


    @Override
    public String toString() {
        return "NewsForSolr{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", image='" + image + '\'' +
                ", commentCount=" + commentCount +
                ", visitCount=" + visitCount +
                ", favoriteCount=" + favoriteCount +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
