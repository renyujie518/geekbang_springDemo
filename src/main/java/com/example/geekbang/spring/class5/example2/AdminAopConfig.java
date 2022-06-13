package com.example.geekbang.spring.class5.example2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: AOP用于日志记录
 * @author: gao wei
 * @create: 2022-01-27 09:44
 */
@Aspect
@Service
@Slf4j
public class AdminAopConfig {
    //管理员在登录时，记录一行日志以便于以后审计管理员操作
    @Before("execution(* com.example.geekbang.spring.class5.example2.AdminUserService.login(..)) ")
    public void logAdminLogin(JoinPoint pjp) throws Throwable {
        System.out.println("! admin login ...");
    }
}
