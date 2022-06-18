package com.example.geekbang.spring.class20.example2.dbcontrol;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;



/**
 * @description Spring 事务是可以对多个数据源生效，它提供了一个抽象类 AbstractRoutingDataSource，
 * 通过实现这个抽象类，我们可以实现自定义的数据库切 换。
 * 继承了 AbstractRoutingDataSource，并覆写 了 determineCurrentLookupKey()：
 */
public class MyDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> key = new ThreadLocal<String>();

    /**
     * @description 选择哪个数据源
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return key.get();
    }

    public static void setDataSource(String dataSource) {
        key.set(dataSource);
    }

    public static String getDatasource() {
        return key.get();
    }

    public static void clearDataSource() {
        key.remove();
    }
}
