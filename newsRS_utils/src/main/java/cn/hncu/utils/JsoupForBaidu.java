package cn.hncu.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Enzo Cotter on 2019/3/21.
 */
public class JsoupForBaidu {
    public static void main(String args[]) throws IOException, ParseException {
        var urlStr = "https://news.baidu.com/";
        //var urlStr = "https://www.china.com/";
//        var urlStr = "http://baijiahao.baidu.com/s?id=1628528968999384960";
        Connection connect = Jsoup.connect(urlStr);
        Document document = connect.get();
        Elements elements_a = document.select("a[href^=http://baijiahao]");//百度新闻的新闻链接为 http://baijiahao


        System.out.println("**********全html标签**************\n" + document);

        System.out.println("________________新闻链接______________");
        elements_a.forEach(element -> {
            String href = element.attr("href");
            System.out.println(href);
            try {
                getContext(href);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        System.out.println("新闻数量 = " + elements_a.size());
    }


    public static void getContext(String url) throws IOException, ParseException {

        Connection connect = Jsoup.connect(url);
        Document document = connect.get();

        Element title = document.select("title").get(0);      //获取标题
        Elements elements = document.select("div[class=article]");
        if (elements.size() == 0 || elements == null) {
            return;   //不是百度原生新闻，返回
        }


        //正文处理
        Element element = elements.select("[class=article-content]").get(0);//获取正文部分
        Elements element_imgs = element.select("img");
        String content = element.toString();
        content = content.replaceAll("article-content","news_content");
        content = content.replaceAll("large","news_img");
        content = content.replaceAll("bjh-p","news_p");
        content = content.replaceAll("img-container","video_img");
        content = content.replaceAll("video-player","news_video");
        //作者logo
        String author_img = elements.select("div[class=author-icon] img").attr("src");

        Element author_name = elements.select("[class=author-name]").get(0);//作者姓名
        Element date = elements.select("[class=date]").get(0);//日期
        Element time = elements.select("[class=time]").get(0);//时间

        System.out.println("**************标题****************\n" + title.text());
        System.out.println("*************作者姓名********************\n" + author_name.text());
        SimpleDateFormat sdf = new SimpleDateFormat("MM-ddhh:mm");
        Date date_now = sdf.parse(date.text() + time.text());
        date_now.setYear(new Date().getYear());
        System.out.println("date_now = " + date_now);
        System.out.println("*****************发布时间***************\n"+date_now);

        System.out.println("\n**************全正文内容*************");
        System.out.println(content);

        System.out.println(element_imgs);

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into news values (null,?,?,?,?,?,?,?)";
        int i = template.update(sql,title.text(),author_name.text(),new Date(),content,url,new Random().nextInt(11)+1,new Random().nextInt(2)+1);
        System.out.println("i = " + i);
    }
}
