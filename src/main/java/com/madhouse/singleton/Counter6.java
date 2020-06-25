package com.madhouse.singleton;

/**
 * @desc: 懒汉式:线程安全,采用静态内部类的方式,也能达到延迟加载,只有被调用的时候才会加载静态内部类
 * @author: yuxinsheng
 * @date: 2020/6/22 15:26
 */
public class Counter6 {

    private static class CounterHolder {
        private static final Counter6 INSTANCE = new Counter6();
    }

    private Counter6() {
    }

    public static Counter6 getInstance() {
        return CounterHolder.INSTANCE;
    }
}
