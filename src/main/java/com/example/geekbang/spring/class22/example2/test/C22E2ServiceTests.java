package com.example.geekbang.spring.class22.example2.test;

import com.example.geekbang.spring.class22.example2.C22E2ServiceOne;
import com.example.geekbang.spring.class22.example2.C22E2ServiceTwo;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @program: geekbang_springDemo
 * @description: 把相关的 MockBean 都定义到一个地方去
 * @author: gao wei
 * @create: 2022-02-10 09:24
 */
public class C22E2ServiceTests {
    @MockBean
    C22E2ServiceOne c22E2ServiceOne;
    @MockBean
    C22E2ServiceTwo c22E2ServiceTwo;
}
