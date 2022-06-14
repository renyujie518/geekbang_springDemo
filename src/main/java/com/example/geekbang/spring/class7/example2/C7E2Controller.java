package com.example.geekbang.spring.class7.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：试图处理并不会抛出的事件
 * @author: gao wei
 * @create: 2022-01-27 11:45
 */

@RestController
public class C7E2Controller {

    @Autowired
    private AbstractApplicationContext applicationContext;

    /**
     * @description 修正2
     * 直接去调用 AbstractApplicationContext#start 方法（执行所有 Lifecycle Bean 的启动方法）
     * 该方法里会抛出ContextStartedEvent事件
     */
    @RequestMapping(path = "c7/e2/publishEvent", method = RequestMethod.GET)
    public String notifyEvent(){
        applicationContext.start();
        return "ok";
    };
}
