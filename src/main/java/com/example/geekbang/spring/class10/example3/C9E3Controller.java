package com.example.geekbang.spring.class10.example3;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：试图在 Controller 中随意自定义 CONTENT_TYPE 等
 * @author: gao wei
 * @create: 2022-01-27 17:01
 */
public class C9E3Controller {
    /*  自定义自定义常用头（本案例是"Content-Type"）失效
     * http://localhost:8080/c9/e3/hi3
     * 修正方式  主动显式指明类型 即 produces = {"application/json"} 只返回一个指明的类型了
     */
    @RequestMapping(path = "/c9/e3/hi3", method = RequestMethod.GET, produces = {"application/json"})
    public String hi3(HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("myheader", "myheadervalue");
        httpServletResponse.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return "ok";
    }
}
