package com.example.geekbang.spring.class3.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：错乱的注入集合
 * @author: gao wei
 * @create: 2022-01-25 15:38
 */

@RestController
@Slf4j
public class C3E2StudentController {

    //备注 这里在注入的时候不需要加@Autowired
    private List<Student> students;

    //显示声明构造器的时候，bean创建会以此创建
    public C3E2StudentController(List<Student> students){
        this.students = students;
    }

    @RequestMapping(path = "students", method = RequestMethod.GET)
    public String listStudents(){
        return students.toString();
    };

}
