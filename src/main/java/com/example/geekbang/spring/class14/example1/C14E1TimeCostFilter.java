package com.example.geekbang.spring.class14.example1;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：@WebFilter 过滤器使用 @Order 无效
 * @author: gao wei
 * @create: 2022-02-07 11:49
 */


/**
 * @description 计算注册学生的执行耗时，需要包括授权过程。
 * 原本使用了 @Order，期望 TimeCostFilter 先被执行，
 * 因为 TimeCostFilter 设计的初衷是统计这个controlle接口的性能，所以是需要统计 AuthFilter 执行的授 权过程的。
 */
//@WebFilter(urlPatterns = { "/c14/e1/*" })
//@Order(1)
@Slf4j
public class C14E1TimeCostFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("#开始计算接口耗时");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("#执行时间(ms)：" + time);
    }
}
