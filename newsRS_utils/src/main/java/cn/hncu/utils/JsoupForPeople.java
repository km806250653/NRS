package cn.hncu.utils;

import cn.hncu.domain.News;
import com.alibaba.druid.pool.DruidDataSourceFactory;
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
import java.util.Random;

/**
 * Created by Enzo Cotter on 2019/3/21.
 */
public class JsoupForPeople {
    public static void main(String args[]) throws IOException, ParseException {
        var urlStr = "http://www.people.com.cn/";
        Connection connect = Jsoup.connect(urlStr);
        Document document = connect.get();
        Elements elements = document.select("div[class^=box] li>a");//  详情页新闻体 常规 class box_con 健康网 articleCont


        elements.forEach(element -> {
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
        System.out.println("新闻数量 = " + elements.size());
    }

    private static void getContext(String url) throws IOException, ParseException {
        if (url.startsWith("http://finance"))  //404,直接返回
            return;

        Document document = Jsoup.connect(url).get();




        Elements elements = document.select("[class=box_con]");
        if(elements==null||elements.size()==0) {
            return;
        }


        Element element = document.select("div[class=box01]>div[class=fl]").get(0);

        //获取标题
        Element title = document.select("title").get(0);

        String dateStr = element.text().substring(0,16);   //截取发布时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
        Date date = sdf.parse(dateStr);  //格式化日期

        String author_name = element.select("a").text();  //作者

        String content = elements.select("div[class=box_con] img,p").toString();
        content="<div class=\"news_content\">"+content+ "</div>";
        content=content.replaceAll("<p","<p class=\"news_p\"");
        content=content.replaceAll("</p>","</span></p>");
        System.out.println("dateStr = " + dateStr);
        System.out.println("date = " + date);
        System.out.println("title = " + title.text());
        System.out.println("content = " + content);
        System.out.println("author_name = " + author_name);

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into news values (null,?,?,?,?,?,?,?)";
        int i = template.update(sql,title.text(),author_name,new Date(),content,url,new Random().nextInt(11)+1,new Random().nextInt(2)+1);
        System.out.println("i = " + i);
    }
}
