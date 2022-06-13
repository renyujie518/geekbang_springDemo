package com.example.geekbang.spring.class2.example1.impl;

import com.example.geekbang.spring.class2.example1.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @program: geekbang_springDemo
 * @description:
 * @author: gao wei
 * @create: 2022-01-25 09:32
 */
/*
*修正方式:显式指明Bean名称（建议此种做法，在写完服务配置@Repository时直接指定类名）
 */
@Repository("CassandraDataService")
@Slf4j
public class CassandraDataService implements DataService {
    @Override
    public void deleteStudent(int id) {
        log.info("delete student info maintained by cassandra");
    }
}

