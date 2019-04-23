package cn.hncu.pojo_group;

import cn.hncu.pojo.News;
import cn.hncu.pojo.NewsImage;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/20.
 */
public class NewsWithImages {
    private News news;
    private List<NewsImage> images;

    public NewsWithImages(News news, List<NewsImage> images) {
        this.news = news;
        this.images = images;
    }

    public NewsWithImages() {
    }

    @Override
    public String toString() {
        return "NewsWithImages{" +
                "news=" + news +
                ", images=" + images +
                '}';
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<NewsImage> getImages() {
        return images;
    }

    public void setImages(List<NewsImage> images) {
        this.images = images;
    }
}
