package com.example.geekbang.spring.class20.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：嵌套事务回滚错误
 * @author: gao wei
 * @create: 2022-02-09 14:01
 */

@Service
public class C20E1CourseService {
    @Autowired
    private C20E1CourseMapper c20E1CourseMapper;

    @Autowired
    private C20E1StudentCourseMapper c20E1StudentCourseMapper;


    /*
    *注意这个方法标记了“Transactional”
    * 情况复现,嵌套事务回滚: @Transactional(rollbackFor = Exception.class)
    *
    * Spring 默认的事务传播属性为 REQUIRED
    * 如果本来有事务，则加入该事务，如果没有事务，则创建新的事务， 因而内外两层事务都处于同一个事务中
    *即默认任何一个环节抛出的异常都会导致全局回滚。
    *
    * 解决方案：
    * 对传播属性进行修改，把类型改成 REQUIRES_NEW  （就会创建一个新的事务，独立于外层事务 让这个子事务单独回滚，不会影响 到主事务。）
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void regCourse(int studentId) throws Exception {
        c20E1StudentCourseMapper.saveStudentCourse(studentId, 1);
        c20E1CourseMapper.addCourseNumber(1);
        throw new Exception("注册失败");
    }
}

