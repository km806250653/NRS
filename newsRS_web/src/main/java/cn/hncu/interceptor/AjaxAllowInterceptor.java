package cn.hncu.interceptor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Enzo Cotter on 2019/4/19.
 */
public class AjaxAllowInterceptor implements HandlerInterceptor {

    @Override
    @CrossOrigin(origins = "*")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 指定允许其他域名访问
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        // 响应类型
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        // 响应头设置
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
//        if ("OPTIONS".equals(request.getMethod())){
//            response.setStatus(HttpStatus.SC_NO_CONTENT);
//        }
        return true;
    }
}
