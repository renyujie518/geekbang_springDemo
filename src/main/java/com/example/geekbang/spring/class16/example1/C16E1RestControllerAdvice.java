package com.example.geekbang.spring.class16.example1;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: geekbang_springDemo
 * @description: 检验不通过的异常处理器（返回 一个 403 的 resultCode）
 * @author: gao wei
 * @create: 2022-02-08 10:13
 */

@RestControllerAdvice
public class C16E1RestControllerAdvice {
    @ExceptionHandler(NotAllowException.class)
    @ResponseBody
    public String handle() {
        System.out.println("403");
        return "{\"resultCode\": 403}";
    }
}
