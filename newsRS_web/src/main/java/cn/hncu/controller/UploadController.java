package cn.hncu.controller;

import java.util.HashMap;
import java.util.Map;

import cn.hncu.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadController {

    private String FILE_SERVER_URL = "http://192.168.25.136/";


    @RequestMapping("/upload")
    public Map<String, Object> upload(MultipartFile imgFile) {
        HashMap<String, Object> map = new HashMap<>();

        //获取文件拓展名
        String originalFilename = imgFile.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:fast_dfs/fast_dfs_client.conf");
            String path = fastDFSClient.uploadFile(imgFile.getBytes(), extName);
            String url = FILE_SERVER_URL+path;
            System.out.println(url);
            map.put("error", 0);
            map.put("url", url);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", 1);
            map.put("message", "上传失败");
            return map;
        }


    }

    @RequestMapping("/deleImage")
    public Map<Object, Object> deleImage(String[] urlArr) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:fast_dfs/fast_dfs_client.conf");
            for (int i = 0; i < urlArr.length; i++) {
                String url=urlArr[i].substring(FILE_SERVER_URL.length());//去掉项目根路径
                fastDFSClient.deleteFile(url);
                System.out.println("已删除:"+url);
            }
            map.put("error", "0");
            map.put("message", "删除成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", "1");
            map.put("message", "删除失败");
            return map;
        }
    }
}
