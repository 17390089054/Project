package org.wrf.aop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.wrf.aop.interceptor.ConfigInterceptor;

/**
 * @program: springBoot-aop
 * @description: 全局拦截器
 * @author: Wang.Rongfu
 * @create: 2019-11-09 18:27
 **/
@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ConfigInterceptor configInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(configInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/register");
        super.addInterceptors(registry);
    }


}
