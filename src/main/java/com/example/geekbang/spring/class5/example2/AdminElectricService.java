package com.example.geekbang.spring.class5.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description:  修改 ElectricService 类实现这个需求：在电费充值时，需要管理员登录并使用其 编号进行结算
 * @author: gao wei
 * @create: 2022-01-26 10:25
 */
@Service
public class AdminElectricService {
    @Autowired
    private AdminUserService adminUserService;
    public void charge() throws Exception {
        System.out.println("Electric charging ...");
        //注意 这里使用了案例一的修正方法 自己@Autowired自己  所以直接使用this.pay()不会有空指针异常
        this.pay();
    }

    public void pay() throws Exception {
        //管理员先登录
        adminUserService.login();
        /*
        *问题出现
         */
        //String payNum = adminUserService.adminUser.getPayNum();
        /*
        *问题修正 通过注入服务adminUserService的get方法
        * 避免ReflectionFactory.newConstructorForSerialization().newInstance()代理类的类属性（admiUser）不会被初始化
        *
         */
        String payNum = adminUserService.getAdminUser().getPayNum();
        System.out.println("User pay num : " + payNum);
        System.out.println("Pay with alipay ...");
        Thread.sleep(1000);
    }
}
