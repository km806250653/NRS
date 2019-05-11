package cn.hncu;

import cn.hncu.pojo.News;
import cn.hncu.pojo.NewsWithImages;
import cn.hncu.service.INewsService;
import cn.hncu.utils.JsoupForBaidu;
import cn.hncu.utils.JsoupForPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Enzo Cotter on 2019/5/11.
 */
@Component
public class MessageListener {

    /**
     * 初始化线程池
     */
    private static ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(10);
    }


    @Autowired
    private INewsService newsService;

    @JmsListener(destination = "crawl")
    public void Crawl() {
        executorService.submit(() -> baiDu());
        executorService.submit(() -> {
                    people();
                    deleOldNews();
                }
        );
    }


    public void baiDu() {
        List<String> urlList = null;
        try {
            //获取百度上的新闻链接
            urlList = JsoupForBaidu.getUrlFromBaiDu();
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlList.forEach(url -> {
            if (url == null) {
                return;
            }
            if (newsService.isExists(url)) {
                System.err.println("该新闻 : <" + url + "> 已存在于数据库");
            } else {
                try {
                    NewsWithImages newsWithImages = JsoupForBaidu.getNewsFromBaiDu(url);
                    newsService.insert(newsWithImages);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void people() {
        List<String> urlList = null;
        try {
            //获取人民网的新闻链接
            urlList = JsoupForPeople.getUrlFromPeople();
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlList.forEach(url -> {
            if (url == null) {
                return;
            }
            if (newsService.isExists(url)) {
                System.err.println("该新闻 : <" + url + "> 已存在于数据库");
            } else {
                try {
                    NewsWithImages newsWithImages = JsoupForPeople.getNewsFromPeople(url);
                    newsService.insert(newsWithImages);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void deleOldNews() {
        try {
            newsService.deleOldNews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
