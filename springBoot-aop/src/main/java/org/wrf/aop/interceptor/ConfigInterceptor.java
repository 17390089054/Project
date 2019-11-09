package org.wrf.aop.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wrf.aop.utils.TraceIdUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springBoot-aop
 * @description: 全局拦截器
 * @author: Wang.Rongfu
 * @create: 2019-11-09 18:12
 **/
@Component
public class ConfigInterceptor implements HandlerInterceptor {
    ThreadLocal<String> traceIDLocal = new ThreadLocal<String>();

    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //System.out.println("控制器前预处理");
        String traceId = TraceIdUtils.generateTraceId();
        //TraceBean tb=new TraceBean();
        //tb.setTraceId(traceId);
        //System.out.println("网关层生成的TraceId--->"+traceId);
        httpServletRequest.setAttribute("traceId", traceId);
        return true;
    }

    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("控制器返回后处理");
    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中
     */

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //System.out.println("视图渲染.....");
    }
}
