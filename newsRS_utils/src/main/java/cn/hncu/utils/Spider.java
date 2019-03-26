package cn.hncu.utils;

import java.io.File;
import java.net.URL;

/**
 * Created by Enzo Cotter on 2019/3/24.
 */
public class Spider {
    public static void getNewsFromBaidu(){

    }

    public static void getNewsFromPeople(){

    }

    public static String DownloadImg(String url){
        return null;
    }

    public static void main(String[] args) {
        URL path = Spider.class.getResource("/");
        System.out.println(path);
    }
}
