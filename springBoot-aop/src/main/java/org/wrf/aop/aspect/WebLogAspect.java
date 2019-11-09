package org.wrf.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.wrf.aop.bean.TraceBean;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @program: springBoot-aop
 * @description: Web层切面日志
 * @author: Wang.Rongfu
 * @create: 2019-11-07 22:53
 **/
@Aspect
@Order(5)
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(String.valueOf(getClass()));

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    private TraceBean tb=new TraceBean();

    FileHandler fileHandler=null;

    private StringBuilder sb=new StringBuilder("");

    @Pointcut("execution(public * org.wrf.aop.controller..*.*(..))")
    public void webLog(){
        System.out.println("接收到一条HTTP请求");
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //是否在控制台输出
        logger.setUseParentHandlers(false);

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String fileName=sdf.format(date)+"-aceessLog.log";

        fileHandler=new FileHandler(System.getProperty("user.dir")+"/"+fileName,true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.INFO);

        logger.addHandler(fileHandler);


        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String traceId=(String)request.getAttribute("traceId");
        //System.out.println("拦截器获取的TraceID--->"+request.getAttribute("traceId"));

        tb.setTraceId(traceId);

        startTime.set(System.currentTimeMillis());
        //获取请求的方法
        //MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //Method method = signature.getMethod();
        //logger.info("METHOD_NAME : "+method.getName());
        // 记录下请求内容
        // logger.info("URL : " + request.getRequestURL().toString());
        sb.append("URL : " + request.getRequestURL().toString()+"; ");
        tb.setUrl(request.getRequestURL().toString());



        //logger.info("HTTP_METHOD : " + request.getMethod());
        sb.append("HTTP_METHOD : " + request.getMethod()+"; ");
        //logger.info("IP : " + request.getRemoteAddr());
        tb.setHttpMethod(request.getMethod());

        //String methodName=joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        String methodName=joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        sb.append("CLASS_METHOD :" +joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+"; ");
        tb.setMethodName(methodName);


        //logger.info("CLASS_METHOD : " + methodName);
        //logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        //logger.info("RESPONSE : " + ret);
        String time=String.valueOf((System.currentTimeMillis() - startTime.get()))+"ms";
        //sb.append("SPEND TIME : " + (System.currentTimeMillis() - startTime.get())+"\n");
        //logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        //logger.info(sb.toString());

        tb.setSpendTime(time);
        //System.out.println(tb.toString());
        logger.info(tb.toString());
        fileHandler.close();
    }


}

