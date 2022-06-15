package com.example.geekbang.spring.class14.example1;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: geekbang_springDemo
 * @description: 案例1: @WebFilter过滤器使用@Order无效
 * @author: gao wei
 * @create: 2022-02-07 21:34
 */

/**
 * @description 修复方法
 * 实现自己的 FilterRegistrationBean 来配置添加过 滤器，不再使用 @WebFilter。
 * 即手工实例化了 FilterRegistrationBean 实例（覆盖默认的），而且设置了其 setOrder()。
 */
@Configuration
public class C14E1FilterConfiguration {
    @Bean
    public FilterRegistrationBean authFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new C14E1AuthFilter());
        registration.addUrlPatterns("/c14/e1/*");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public FilterRegistrationBean timeCostFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new C14E1TimeCostFilter());
        registration.addUrlPatterns("/c14/e1/*");
        registration.setOrder(1);
        return registration;
    }
}
