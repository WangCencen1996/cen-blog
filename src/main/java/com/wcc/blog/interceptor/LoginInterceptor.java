package com.wcc.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * 拦截没有登录却又想访问需要登陆才能访问的页面的请求
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断用户是否登录
        if (request.getSession().getAttribute("user") == null){
            //没有登录，重定向到登录页面
            response.sendRedirect("/admin");
            return false;
        }
        //已登录，继续访问
        return true;
    }
}
