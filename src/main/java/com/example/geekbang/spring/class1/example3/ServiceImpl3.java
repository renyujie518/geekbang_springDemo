package com.example.geekbang.spring.class1.example3;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
//通知Spring把被注解的Bean变成多例
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
/**
 * 设置多例
 */
public class ServiceImpl3 {
}
