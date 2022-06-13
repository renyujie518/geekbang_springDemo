package com.example.geekbang.spring.class4.example2;

/**
 * @program: geekbang_springDemo
 * @description: bean注册时额外注意shutdown 或者 close 的方法
 * 使用 Bean 注解的方法所注册的 Bean 对象，如果用户不设置 destroyMethod 属性，则其属性值为 AbstractBeanDefinition.INFER_METHOD。
 * 此时 Spring 会检查当前 Bean 对象的原始类中是否有名为 shutdown 或者 close 的方法，如果有，此方法会被 Spring 记录下来，
 * 并在容器被销毁时自动执行；当然如若没有，那么自然什么都不会发生。
 * @author: gao wei
 * @create: 2022-01-26 09:56
 */


import com.example.geekbang.spring.class4.example1.LightService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BeanConfiguration {
    /*
    *修正方式:将 Bean 注解内 destroyMethod 属性设置为空
    *  防止pring 容器 被销毁时自动调用@Bean对象中名为的 close 或者 shutdown 方法
    * 注意：上一个@Service 来产生 Bean案例中不会出现上述情况
     */
    @Bean(destroyMethod="")
    public LightService getTransmission(){
        return new LightService();
    }
}
