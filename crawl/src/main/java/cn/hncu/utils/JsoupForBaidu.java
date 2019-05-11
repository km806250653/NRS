package cn.hncu.utils;

import cn.hncu.pojo.News;
import cn.hncu.pojo.NewsImage;
import cn.hncu.pojo.NewsWithImages;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Enzo Cotter on 2019/3/21.
 */
public class JsoupForBaidu {

    public static List<String> getUrlFromBaiDu() throws IOException {
        ArrayList<String> urlList = new ArrayList<>();
        String urlStr = "https://news.baidu.com/";
        Document document = null;
        try {
            document = Jsoup.connect(urlStr).get();
        } catch (IOException e) {
            System.err.println("连接百度失败，检查网络");
        }
        Elements elements_a = document.select("a[href^=http://baijiahao]");//百度新闻的新闻链接为 http://baijiahao

        elements_a.forEach(element -> {
            //获取url
            String href = element.attr("href");
            urlList.add(href);
        });
        return urlList;
    }

    public static NewsWithImages getNewsFromBaiDu(String url) throws Exception {

        //获取连接
        //获取DOM对象
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.err.println("连接失败："+url);
            return null;
        }
        if(document == null){
            return null;
        }

        Elements elements = document.select("div[class=article]");
        if (elements.size() == 0 || elements == null) {
            return null;   //不是百度原生新闻，返回
        }

        News news = new News();
        List<NewsImage> images = new ArrayList<>();
        //设置源地址
        news.setSource(url);
        //获取标题设置进news对象
        Element title = document.select("title").get(0);      //获取标题
        news.setTitle(title.text());

        //正文处理
        Element element = elements.select("[class=article-content]").get(0);
        //获取图片
        Elements element_imgs = element.select("img");
        //图片上传并替换正文中的图片链接
        for (Element image : element_imgs) {
            //下载生成临时文件
            String filename = DownloadFileUtils.downloadImage(image.attr("src"));
            if (filename == null){
                image.attr("style","visibility: hidden");
                continue;
            }
            //上传文件到fastdfs
            FastDFSClient fastDFSClient = new FastDFSClient();
            String path = fastDFSClient.uploadFile(filename);
            String fdfsUrl = "http://192.168.25.136/" + path;
            images.add(new NewsImage(fdfsUrl));
            //将url替换成fastdfs上的url
            image.attr("src", fdfsUrl);
            //删除临时文件
            DownloadFileUtils.delete(filename);
        }
        //设置正文
        news.setContent(element.toString());

        //作者logo
        String author_img = elements.select("div[class=author-icon] img").attr("src");

        Element author_name = elements.select("[class=author-name]").get(0);//作者姓名

        news.setAuthor(author_name.text());

        Element date = elements.select("[class=date]").get(0);//日期
        Element time = elements.select("[class=time]").get(0);//时间

        //时间解析
        SimpleDateFormat sdf = new SimpleDateFormat("MM-ddhh:mm");
        Date date_now = null;
        try {
            date_now = sdf.parse(date.text() + time.text());
        } catch (ParseException e) {
            System.err.println("时间解析出现异常");
        }
        date_now.setYear(new Date().getYear());
        news.setReleaseDate(date_now);

        //随机设置分类
        news.setCid(new Random().nextInt(11) + 1);
        //设置第一张图片作为封面
        if (images.size() > 0) {
            news.setImage(images.get(0).getUrl());
        }
        //设置发布者为system
        news.setUid(1);
        return new NewsWithImages(news, images);
    }
}
