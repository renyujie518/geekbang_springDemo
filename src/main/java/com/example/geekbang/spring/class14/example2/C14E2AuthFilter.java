package com.example.geekbang.spring.class14.example2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：过滤器被多次执行
 * @author: gao wei
 * @create: 2022-02-07 11:49
 */
/*
 *情况复现  要解决排序问题，能否在两个过滤器中增加 @Component，从而让 @Order 生效呢？
 * 结论是可以  但  ，过滤器本身被执行了 2 次
 * 原因：被 @WebFilter 的过滤器，会在 WebServletHandler 类中被重 新包装为 FilterRegistrationBean 类的 BeanDefinition，而并非是 Filter 类型
 * 在自定义过滤器中增加 @Component 时，Spring 会根据当前类再次包装一个新的过滤器，因而 doFIlter() 被执行两次。
 *
 * 关键词 再次包装一个新的过滤器
 *
 * 任何通过 @Component 修饰的的类，都可以自动注册到 Spring，且能被 Spring 直接实例化
 * ！！！，当过滤器同时被 @WebFilter 和 @Component 修饰时，会导致两个 FilterRegistrationBean 实例的产生
 *
 *
 * 解决方案1  实现自己的 FilterRegistrationBean 来配置添加过 滤器，不再使用 @WebFilter（与案例1同）来解决顺序问题
 *        2   去掉 @WebFilter 保留 @Component 的方式进行修改 同时设置@Order保证执行顺序
 */
//@WebFilter(urlPatterns = { "/c14/e2/*" })
@Order(2)
@Slf4j
@Component
public class C14E2AuthFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        if (isPassAuth()) {
            System.out.println("通过授权");
            chain.doFilter(request, response);
        } else {
            System.out.println("未通过授权");
            ((HttpServletResponse) response).sendError(401);
        }
    }

    private boolean isPassAuth() throws InterruptedException {
        System.out.println("执行检查权限");
        Thread.sleep(1000);
        return true;
    }
}
