package com.example.geekbang.spring.class10.example2;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2 在 HTTP 协议中，Header 的名称是无所谓大小写的
 * @author: gao wei
 * @create: 2022-01-27 17:01
 */
public class C9E2Controller {
    /*
     *GET http://localhost:8080/hi2
     * myheader: myheadervalue
     * 注意 此时的@中的获取参数是"MyHeader"
     */

    @RequestMapping(path = "/c9/e2/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader("MyHeader") String myHeader) {
        return myHeader;
    }

    /*
    使用 Map 来接收所有的 Header
     *问题情况  如果此时还是忽略大小写 会出现结果  myheadervalue compare with : null
     即直接获取 Header 是可以忽略大小写的，但是如果从接收过来的 Map 中获取 Header 是不能忽略大小写的
     */
    @RequestMapping(path = "/c9/e2/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader("MyHeader") String myHeader, @RequestHeader MultiValueMap map) {
        return myHeader + " compare with : " + map.get("MyHeader");
    }

    /*
    myheader: myheadervalue
     *修正方式一   接收类型 Map 中获取 Header 时注意下大小写
     */
    @RequestMapping(path = "/c9/e2/hi2/modify", method = RequestMethod.GET)
    public String hi2Modify(@RequestHeader("MyHeader") String myHeader, @RequestHeader MultiValueMap map) {
        return myHeader + " compare with : " + map.get("myHeader");
    }
    /*
     *修正方式二
     * HttpHeaders 底层用的是LinkedCaseInsensitiveMap，是可以忽略大小写的
     */

    @RequestMapping(path = "/c9/e2/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader("MyHeader") String myHeader, @RequestHeader HttpHeaders map){
        return myHeader + " compare with : " + map.get("MyHeader");
    };
}
