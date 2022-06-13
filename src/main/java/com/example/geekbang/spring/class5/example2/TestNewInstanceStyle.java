package com.example.geekbang.spring.class5.example2;

/**
 * @program: geekbang_springDemo
 * @description: 课后习题
 * 通过反射来实例化类的三种方式
 * java.lang.Class.newInsance()
 * java.lang.reflect.Constructor.newInstance()
 * sun.reflect.ReflectionFactory.newConstructorForSerialization().newInstance()
 * 其中第三种方式不会初始化类属性，你能够写一个例子来证明这一点吗？
 * @author: gao wei
 * @create: 2022-01-27 14:02
 */

import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;

public class TestNewInstanceStyle {

    //测试类  类属性为name
    public static class TestObject {
        public String name = "fujian";
    }

    public static void main(String[] args) throws Exception {
        /*
         * ReflectionFactory.newConstructorForSerialization()方式  注意是sun包下的
         */
        ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();
        Constructor constructor = reflectionFactory.newConstructorForSerialization(TestObject.class, Object.class.getDeclaredConstructor());
        constructor.setAccessible(true);
        TestObject testObject1 = (TestObject) constructor.newInstance();
        System.out.println(testObject1.name);
        //普通方式
        TestObject testObject2 = new TestObject();
        System.out.println(testObject2.name);
    }

}
