package com.example.geekbang.spring.class12.example1;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：对象参数校验失效
 * @author: gao wei
 * @create: 2022-02-07 09:57
 */
@Data
public class C12E1Student {
    //最大为 10 字节），以拦截姓 名过长、不符合“常情”的学生信息的添加。
    @Size(max = 10)
    private String name;
    private short age;
}
