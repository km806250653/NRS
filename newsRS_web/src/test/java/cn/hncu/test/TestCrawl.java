package cn.hncu.test;

import cn.hncu.pojo_group.NewsWithImages;
import cn.hncu.service.INewsService;
import cn.hncu.utils.JsoupForBaidu;
import cn.hncu.utils.JsoupForPeople;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-*.xml",
        "classpath:springmvc.xml"
})
public class TestCrawl {

    @Autowired
    private INewsService newsService;

//    @Test
//    public void baiDu() throws IOException {
//        List<String> urlList = JsoupForBaidu.getUrlFromBaiDu();
//        urlList.forEach(url -> {
//            if(url==null){
//                return;
//            }
//            if (newsService.isExists(url)) {
//                System.err.println("该新闻 : <" + url + "> 已存在于数据库");
//            }else {
//                try {
//                    NewsWithImages newsWithImages = JsoupForBaidu.getNewsFromBaiDu(url);
//                    newsService.insert(newsWithImages);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
    @Test
    public void deleteOne() throws Exception {
        newsService.deleById(2109);
    }
//
//    @Test
//    public void people() throws IOException {
//        List<String> urlList = JsoupForPeople.getUrlFromPeople();
//        urlList.forEach(url -> {
//            if(url==null){
//                return;
//            }
//            if (newsService.isExists(url)) {
//                System.err.println("该新闻 : <" + url + "> 已存在于数据库");
//            }else {
//                try {
//                    NewsWithImages newsWithImages = JsoupForPeople.getNewsFromPeople(url);
//                    newsService.insert(newsWithImages);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    @Test
//    public void deleCrawlNews() {
//        try {
////            newsService.deleCrawlNews();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
