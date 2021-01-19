package com.shouko.blog.aspect;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author ：ShoukoNx
 * @Date ：Created in 2020/12/14 20:06
 * @Description： 日志切面处理
 * @Version: 1.0.0
 */

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //切面，对于所有controller进行日志记录
    @Pointcut("execution(* com.shouko.blog.controller.*.*(..))")
    public void log(){ }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        //创建单条日志信息
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request : {}", requestLog);
    }


    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("result : {}", result);
    }


    //内部类，单条日志信息
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url; //所访问的URL
            this.ip = ip; //访问者的ip
            this.classMethod = classMethod; //所调用的类和方法
            this.args = args; //传入的参数
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
