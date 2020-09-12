package com.wcc.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日志处理
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    // 定义切面
    @Pointcut("execution(* com.wcc.blog.web.*.*(..))")
    public void log(){}

    // 在请求之前执行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        // 获取请求的url
        String url = request.getRequestURL().toString();
        // 获取请求的ip地址
        String ip = request.getRemoteAddr();
        // 获取请求的方法的名称
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        // 获取请求参数
        Object[] args = joinPoint.getArgs();
        //RequestLog requestLog = new RequestLog(url,ip,classMethod,args);
        logger.info("Request: url={}, ip={},classMethod={}, args={}", url, ip, classMethod, args);
    }

    // 在请求之后执行
    @After("log()")
    public void doAfter(){
        //logger.info("-------------doAfter---------------");
    }

    // 拦截返回
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);
    }

    /*private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] arps;

        public RequestLog(String url, String ip, String classMethod, Object[] arps) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.arps = arps;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", arps=" + Arrays.toString(arps) +
                    '}';
        }
    }*/

}
