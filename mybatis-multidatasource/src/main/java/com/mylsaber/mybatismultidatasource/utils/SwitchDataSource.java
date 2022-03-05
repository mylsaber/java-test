package com.mylsaber.mybatismultidatasource.utils;

/**
 * @author jfw
 */
public class SwitchDataSource {
    /**
     * ThreadLocal,叫线程本地变量或线程本地存储。
     * ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
     * 这里使用它的子类InheritableThreadLocal用来保证父子线程都能拿到值。
     */
    private static final ThreadLocal<String> DATA_SOURCE_KEY = new InheritableThreadLocal<>();

    /**
     * 设置dataSourceKey的值
     *
     */
    public static void setDataSource(String dataSource) {
        DATA_SOURCE_KEY.set(dataSource);
    }

    /**
     * 清除dataSourceKey的值
     */
    public static void toDefault() {
        DATA_SOURCE_KEY.remove();
    }

    /**
     * 返回当前dataSourceKey的值
     */
    public static Object getDataSource() {
        return DATA_SOURCE_KEY.get();
    }
}
