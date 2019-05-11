package cn.hncu.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.UUID;

/**
 * Created by Enzo Cotter on 2019/4/20.
 */
public class DownloadFileUtils {

    public static String  downloadImage(String urlStr) {
        URL url = null;
        BufferedInputStream bis =null;
        FileOutputStream fos = null;
        String filename = null;
        try {
            url = new URL(urlStr);
            bis = new BufferedInputStream(url.openStream());
            filename = UUID.randomUUID()+".jpg";
            fos = new FileOutputStream(filename);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        } catch (Exception e) {
            System.err.println("图片下载失败："+url);
            return null;
        } finally {
            try {
                fos.close();
                bis.close();
            } catch (Exception e) {
                System.out.println("未获取到连接，文件不存在或有防盗链");
            }
        }
        return filename;
    }

    public static void delete(String filename){
        File file = new File(filename);
        if(file.exists()){
            file.delete();
        }
    }

}
