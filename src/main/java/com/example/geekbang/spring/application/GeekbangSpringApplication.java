package com.example.geekbang.spring.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("com.example.geekbang.spring.class*.*")
//第5课  将代理对象放入到 ThreadLocal 可以直接通过 AopContext.currentProxy() 的方式获取到当前的Proxy
@EnableAspectJAutoProxy(exposeProxy = true)
@ServletComponentScan("com.example.geekbang.spring.class*.*")
@Slf4j
public class GeekbangSpringApplication {
    /**
     * 18课 注意读与取的一致性
     * 问题修复  读取使用相同的 RedisTemplate
     * @param redisTemplate
     * @param stringRedisTemplate
     */
    //void SpringdataApplication(RedisTemplate redisTemplate, StringRedisTemplate stringRedisTemplate) {
    //    String key = "mykey";
    //    stringRedisTemplate.opsForValue().set(key, "myvalue");
    //    //使用stringRedisTemplate
    //    Object valueGotFromStringRedisTemplate = stringRedisTemplate.opsForValue().get(key);
    //    System.out.println(valueGotFromStringRedisTemplate);
    //    //使用RedisTemplate（取不到对应数据）
    //    Object valueGotFromRedisTemplate = redisTemplate.opsForValue().get(key);
    //    System.out.println(valueGotFromRedisTemplate);
    //}

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GeekbangSpringApplication.class, args);
        log.info("启动成功");
        /*
         *服务完整运行后停止
         */
        //context.close();
        //log.info("服务完整运行后停止");
    }

}
