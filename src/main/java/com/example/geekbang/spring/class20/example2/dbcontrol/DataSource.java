package com.example.geekbang.spring.class20.example2.dbcontrol;

import java.lang.annotation.*;

/**
 * @description 把配置的数据源类型都设置成注解标签，
 * Service 层中 在切换数据源的方法上加上注解标签，就会调用相应的方法切换数据源
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value();

    String core = "core";

    String card = "card";
}
