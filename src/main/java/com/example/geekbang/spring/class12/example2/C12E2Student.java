package com.example.geekbang.spring.class12.example2;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：嵌套校验失效
 * 会根据成员字段是否标记了 @Valid 来决定（记录）这个 字段以后是否做级联校验
 * 只 能用 @Valid 去开启级联校验。
 * @author: gao wei
 * @create: 2022-02-07 09:57
 */
@Data
public class C12E2Student {
    @Size(max = 10)
    private String name;
    private short age;
    //注意 这里不能使用@Validated 因为其定义中不允许修饰一个 Field
    @Valid //开启级联校验
    private C12E2Phone phone;
}
