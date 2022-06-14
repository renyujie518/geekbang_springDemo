package com.example.geekbang.spring.class7.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：错乱混合不同类型的增强
 * 写一个 Lifecycle Bean（真实作用：实现运行中的启停）
 * 只要执行了 AbstractApplicationContext 的 start()， 如执行C7E2Controller#notifyEvent
 * 就会输出日志lifecycle start
 * @author: gao wei
 * @create: 2022-01-27 12:44
 */

@Component
@Slf4j
public class MyLifeCycle implements Lifecycle {

    private volatile boolean running = false;

    @Override
    public void start() {
        log.info("---------------------MyLifeCycle.start-----------------------------------");
        log.info("lifecycle start");
        log.info("--------------------------------------------------------");
        running = true;
    }

    @Override
    public void stop() {
        log.info("---------------------MyLifeCycle.stop-----------------------------------");
        log.info("lifecycle stop");
        log.info("--------------------------------------------------------");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

}
