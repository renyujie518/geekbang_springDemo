package com.example.geekbang.spring.class13.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：@WebFilter 过滤器无法被自动注入
 * 我们可能需要把 TimeCostFilter 记录的统计数据输出到专业的度量系统（ElasticeSearch/InfluxDB 等）里 面去
 * 添加如下的一个@Service,将过滤器注入
 * @author: gao wei
 * @create: 2022-02-07 11:57
 */
@Service
public class C13E1MetricsService {

    /*
     *修正方式
     */
    @Autowired
    //注入的名称是包含包名的长名称，即 com.spring.puzzle.filter.TimeCostFilter（不能用 TimeCostFilter），以便于存在多个过滤器时进行精确匹配
    @Qualifier("com.example.geekbang.spring.class13.example1.C13E1TimeCostFilter")
    //1.注入的类型是 FilterRegistrationBean 类型，而不是 TimeCostFilter 类型
    public FilterRegistrationBean c13E1TimeCostFilter;
    //省略其他非关键代码
}
