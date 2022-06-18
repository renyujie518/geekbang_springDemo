package com.example.geekbang.spring.class20.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：嵌套事务回滚错误
 * @author: gao wei
 * @create: 2022-02-09 13:13
 */

@Service
public class C20E1StudentService {
    @Autowired
    private C20E1StudentService c20E1StudentService;
    @Autowired
    private C20E1CourseService c20E1CourseService;
    @Autowired
    private C20E1StudentMapper c20E1StudentMapper;

    /**
     * @description 希望的结果是，当注册课程发生错误时，只回滚注册课程部分，保 证学生信息保存依然正常。
     * 即内 部事务应自行回滚，不影响外部事务
     * 问题出现  在 regCourse() 里抛出了一个注册失败的异常 学生注册（外部事务）和选课的信息（内部事务）都被回滚了
     * 原因：当我们在 regCourse() 中抛出异常，并触 发了回滚操作时，这个回滚会进一步传播，从而把 saveStudent() 也回滚了。最终导致整 个事务都被回滚了。
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(String realname) throws Exception {
        C20E1Student student = new C20E1Student();
        student.setRealname(realname);
        //1.先保存学生信息
        int studentId = c20E1StudentService.doSaveStudent(student);
        //为了避免注册课程的业务异常导致学生信息无法保存，在这里 catch 了注册课程方 法中抛出的异常。
        try {
            c20E1CourseService.regCourse(studentId);
        } catch (Exception e) {
            //注意  这里没有继续throw
            e.printStackTrace();
        }
    }

    @Transactional
    public int doSaveStudent(C20E1Student student) throws Exception {
        int studentId = c20E1StudentMapper.saveStudent(student);
        return studentId;
    }
//省略非关键代码
}

