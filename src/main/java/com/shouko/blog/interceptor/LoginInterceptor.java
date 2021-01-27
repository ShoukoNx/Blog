package com.shouko.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2021/1/25 20:28
 * @Description： 登陆过滤拦截
 * @Version: 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //session里如果没有用户就重定向至登陆首页
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("admin");
            return false;
        }
        return true;
    }
}
