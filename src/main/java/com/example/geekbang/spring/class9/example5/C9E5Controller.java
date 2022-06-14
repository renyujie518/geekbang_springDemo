package com.example.geekbang.spring.class9.example5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @program: geekbang_springDemo
 * @description: 思考题
 * @author: gao wei
 * @create: 2022-01-27 15:38
 */

@RestController
@Slf4j
public class C9E5Controller {


    /**
     * @description GET http://localhost:8080/c9/e5/hi2?name=xiaoming&name=hanmeimei
     * 类似这种有多个name的，可以使用String[]完成接收 结果为 [xiaoming, hanmeimei]
     * （比直接用String接收后的结果  xiaoming,hanmeimei  好，否则还要split再取）
     */
    @RequestMapping(path = "/c9/e5/hi2", method = RequestMethod.GET)
    public String hi2(@RequestParam("name") String[] name){
        return Arrays.toString(name);
    };
}
