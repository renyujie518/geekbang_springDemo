package com.example.geekbang.spring.class6.example1;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：错乱混合不同类型的增强
 * @author: gao wei
 * @create: 2022-01-27 10:36
 */

//省略 import
//把当前类标识为一个切面供容器读取
@Aspect
@Service
@Slf4j
public class C6E1AspectService {
    /*
    *切面注解排序: 依次为 Around.class, Before.class, After.class, AfterReturning.class, AfterThrowing.class
     */
    //before 模拟鉴权
    @Before("execution(* com.example.geekbang.spring.class6.example1.C6E1ElectricService.charge()) ")
    public void checkAuthority(JoinPoint pjp) throws Throwable {
        System.out.println("validating user authority");
        Thread.sleep(1000);
    }

    //around  模拟记录耗时 注意这里的目的是仅统计doCharge的耗时
    @Around("execution(* com.example.geekbang.spring.class6.example1.C6E1ElectricService.doCharge()) ")
    public void recordPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("charge method time cost: " + (end - start) + "ms");
    }
}
