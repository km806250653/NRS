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
public class JsoupForPeople {
    public static List<String> getUrlFromPeople() throws IOException {
        ArrayList<String> urlList = new ArrayList<>();
        String urlStr = "http://www.people.com.cn/";
        Document document = null;
        try {
            document = Jsoup.connect(urlStr).get();
        } catch (IOException e) {
            System.err.println("连接人民网失败，请检查网络");
        }

        Elements elements = document.select("div[class^=box] li>a");//  详情页新闻体 常规 class box_con 健康网 articleCont

        elements.forEach(element -> {
            String href = element.attr("href");
            urlList.add(href);
        });
        return urlList;
    }

    public static NewsWithImages getNewsFromPeople(String url) throws Exception {
        if (url.startsWith("http://finance"))  //404,直接返回
            return null;

        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.err.println("连接失败："+url);
        }
        if(document == null){
            return null;
        }
        Elements elements = document.select("[class=box_con]");
        if(elements==null||elements.size()==0) {
            return null;
        }

        News news = new News();
        List<NewsImage> images = new ArrayList<>();

        //设置来源
        news.setSource(url);
        Element element = document.select("div[class=box01]>div[class=fl]").get(0);
        //获取标题
        Element title = document.select("title").get(0);
        //设置标题
        news.setTitle(title.text());

        //设置发布时间
        //截取发布时间
        try {
            String dateStr = element.text().substring(0,16);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
            Date date = sdf.parse(dateStr);  //格式化日期
            news.setReleaseDate(date);
        } catch (ParseException e) {
            System.err.println("格式化日期错误");
        }
        String author_name = element.select("a").text();  //作者
        //设置作者
        news.setAuthor(author_name);

        Elements content = elements.select("div[class=box_con]");

        Elements imagesDOM = content.select("img");
        for (Element imageDoM : imagesDOM) {
            //下载生成临时文件
            String filename = DownloadFileUtils.downloadImage(imageDoM.attr("src"));
            if (filename == null)
                continue;
            //上传文件到fastdfs
            FastDFSClient fastDFSClient = new FastDFSClient();
            String path = fastDFSClient.uploadFile(filename);
            String fdfsUrl = "http://192.168.25.136/" + path;
            images.add(new NewsImage(fdfsUrl));
            //将url替换成fastdfs上的url
            imageDoM.attr("src", fdfsUrl);
            //删除临时文件
            DownloadFileUtils.delete(filename);
        }

        news.setContent(content.toString());
        if(images.size()>0){
            news.setImage(images.get(0).getUrl());
        }
        //分类……随机吧
        news.setCid(new Random().nextInt(11)+1);
        //1号用户是system
        news.setUid(1);
        news.setFavoriteCount(0);
        news.setVisitCount(0);
        news.setCommentCount(0);
        news.setStatus(1);
        return new NewsWithImages(news, images);
    }
}
