package com.madhouse.singleton;

/**
 * @desc: 饿汉式:线程安全
 * @author: yuxinsheng
 * @date: 2020/6/22 15:26
 */
public class Counter3 {

    private static Counter3 counter = new Counter3();

    private Counter3() {
        System.out.println("私有构造器");
    }

    public static Counter3 getInstance() {
        return counter;
    }
}
