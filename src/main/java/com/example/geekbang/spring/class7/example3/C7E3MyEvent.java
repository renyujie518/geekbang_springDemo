package com.example.geekbang.spring.class7.example3;

import org.springframework.context.ApplicationEvent;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：部分事件监听器失效
 * 自定义一个事件叫C7E3MyEvent  该事件的监听器会模拟由于抛出异常会导致失效
 * 答案: 最终事件的执行是由同一个线程按顺序来完成的，任何一个报错，都会导致后续的监听器执行不了。
 * @author: gao wei
 * @create: 2022-01-27 13:33
 */
public class C7E3MyEvent extends ApplicationEvent {
    //构造函数
    public C7E3MyEvent(Object source) {
        super(source);
    }
}
