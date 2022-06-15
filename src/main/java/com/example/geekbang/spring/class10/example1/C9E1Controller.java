package com.example.geekbang.spring.class10.example1;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：接受 Header 使用错 Map 类型
 * @author: gao wei
 * @create: 2022-01-27 17:01
 */
public class C9E1Controller {

    @RequestMapping(path = "/c9/e1/hi", method = RequestMethod.GET)
    public String hi(@RequestHeader("myHeaderName") String name) {
        //省略 body 处理
        return name;
    }

    /*
     *问题情况 Header 有两个值:
     * GET http://localhost:8080/c9/e1/hi1
     * myheader: h1
     * myheader: h2
     * map中只有myheader=h1  当一个请求出现多个同名 Header 时，我们只要匹配上任何一个即立马返回。
     */
    @RequestMapping(path = "/c9/e1/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader() Map map) {
        return map.toString();
    }

    /*
     *修正方式一： @RequestHeader() MultiValueMap map
     *返回值是字符串数组  String[] headerValues
     * 结果： [myheader:"h1", "h2",....]
     */
    @RequestMapping(path = "/c9/e1/hi2/modify1", method = RequestMethod.GET)
    public String hi2Modify1(@RequestHeader() MultiValueMap map) {
        return map.toString();
    }

    /*
     *《推荐》修正方式二： @RequestHeader() HttpHeaders map（本质上也是一种MultiValueMap）
     */
    @RequestMapping(path = "/c9/e1/hi2/modify2", method = RequestMethod.GET)
    public String hi2Modify2(@RequestHeader() HttpHeaders map) {
        return map.toString();
    }
}
