package com.example.geekbang.spring.class19.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：unchecked 异常与事务回滚
 * @author: gao wei
 * @create: 2022-02-09 13:13
 */

@Service
public class C19E1StudentService {
    @Autowired
    private C19E1StudentMapper c19E1StudentMapper;

    /*
     * 情况复现: 抛出异常但事务没有回滚
     * @Transactional   配置了 rollbackFor
     * 如果捕获到的异常是 rollbackFor 配置的异常或其子 类，就会直接 rollback。
     * 如果没有在 @Transactional 中配置 rollback 属性，那么只有捕获到 RuntimeException 或者 Error 的时候才会触发回滚操 作。
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(String realname) throws Exception {
        C19E1Student student = new C19E1Student();
        student.setRealname(realname);
        c19E1StudentMapper.saveStudent(student);
        /** 测试一下这个事务会不会回滚 如果发现用 户名是小明，就直接抛出异常，触发事务的回滚操作 **/
        if (student.getRealname().equals("小明")) {
            throw new Exception("该学生已存在");
        }
    }
}

