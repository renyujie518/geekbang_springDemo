package com.example.geekbang.spring.class16.example2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：特殊的 404 异常
 * 模拟记录所有 404 状态的访问 记录，并返回一个我们的自定义结果（即还是走自定义的异常处理器 MyExceptionHandler）
 * @author: gao wei
 * @create: 2022-02-08 10:58
 */
//RestControllerAdvice+ExceptionHandler这两个注解的组合，被用作项目的全局异常处理
//RestControllerAdvice的作用范围是：单个项目中所有使用了RequestMapping（像PostMapping底层是使用了RequestMapping注解的也支持）的类都归他管
@RestControllerAdvice
public class C16E2ExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    //会抛出 NoHandlerFoundException 异常，从而被 doDispatch() 内的 catch 俘获。
    // 进而就像案例 1 介绍的一样，最终能够执行我们自定义的异常处理器 MyExceptionHandler
    @ExceptionHandler(NoHandlerFoundException.class)
    //ResponseBody的作用是将返回前端的参数转化成json格式，说白了就是以json数据与前端进行交互
    @ResponseBody
    public String handle404() {
        System.out.println("404");
        return "{\"resultCode\": 404}";
    }
}
