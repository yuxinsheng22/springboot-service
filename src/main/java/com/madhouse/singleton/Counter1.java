package com.madhouse.singleton;

import java.util.Objects;

/**
 * @desc: 懒汉式:线程不安全
 * @author: yuxinsheng
 * @date: 2020/6/22 15:26
 */
public class Counter1 {

    private static Counter1 counter;

    private Counter1() {
        System.out.println("私有构造器");
    }

    public static Counter1 getInstance() {
        if (Objects.isNull(counter)) {
            counter = new Counter1();
        }
        return counter;
    }
}
