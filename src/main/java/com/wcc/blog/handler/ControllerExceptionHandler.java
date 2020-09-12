package com.wcc.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 错误拦截
 * 全局异常处理
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 异常处理方法
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        // 日志记录异常信息
        logger.error("Request URL: {}, Exception: {}",request.getRequestURL(), e);
        // 判断异常是否标识了状态码（404,500）
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        // 获取请求地址
        mv.addObject("url",request.getRequestURL());
        // 获取错误信息
        mv.addObject("exception",e);
        // 将请求地址和错误信息返回到error.html显示
        mv.setViewName("error/error");
        return mv;
    }

}
