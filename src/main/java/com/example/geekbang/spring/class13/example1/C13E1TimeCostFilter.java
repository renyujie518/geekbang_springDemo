package com.example.geekbang.spring.class13.example1;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：@WebFilter 过滤器无法被自动注入
 *
 * @ServletComponentScan + @WebFilter，
 * 过滤器使用时需要在启动类上加上@ServletComponentScan注解，并保证过滤器所在的包可以被扫描到
 *
 * 过滤器被 @WebFilter 修饰后，TimeCostFilter 只会被包装为 FilterRegistrationBean，
 * 而 TimeCostFilter 自身，只会作为一个 InnerBean 被实例化，
 * 这意味着 TimeCostFilter 实例并不会作为 Bean 注册到 Spring 容器
 * 即当使用 @WebFilter 修饰过滤器时，TimeCostFilter 类型的 Bean 并没有注册到 Spring 容器中
 * 真正注册的是 FilterRegistrationBean
 * @author: gao wei
 * @create: 2022-02-07 11:49
 */
//统计接口耗时过滤器
@WebFilter(urlPatterns = { "/c13/e1/*" })
@Slf4j
public class C13E1TimeCostFilter implements Filter {
    public void C13E1TimeCostFilter() {
        System.out.println("construct");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----C13E1TimeCostFilter过滤器初始化----");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("开始计算接口耗时");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("执行时间(ms)：" + time);
    }
}
