package cn.hncu.utils.other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Enzo Cotter on 2019/4/16.
 */
public class GetTest {
    public static void main(String[] args) {
        String s = SendGET("http://pv.sohu.com/cityjson");
        s=s.substring(s.indexOf("=")+2);
        s=s.substring(0,s.length()-1);
//        String s = SendGET("http://ip.taobao.com/service/getIpInfo.php?ip=211.161.168.225");
        System.out.println(s);
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject.get("cip"));
        String ss = SendGET("http://ip.taobao.com/service/getIpInfo.php?ip="+jsonObject.get("cip"));
        System.out.println(ss);
    }
    public static String SendGET(String url){
        String result="";//访问返回结果
        BufferedReader read=null;//读取访问结果

        try {
            //创建url
//            URL realurl=new URL(url+"?"+param);
            URL realurl=new URL(url);
            //打开连接
            URLConnection connection=realurl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //建立连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段，获取到cookies等
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            read = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;//循环读取
            while ((line = read.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(read!=null){//关闭流
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

}
