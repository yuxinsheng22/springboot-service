package com.madhouse.singleton;

import java.util.Objects;

/**
 * @desc: 懒汉式:线程安全(volatile+double check)
 * @author: yuxinsheng
 * @date: 2020/6/22 15:26
 */
public class Counter5 {

    private volatile static Counter5 counter = null;

    private Counter5() {
        System.out.println("私有构造器");
    }

    public static Counter5 getInstance() {
        if (Objects.isNull(counter)) {
            synchronized (Counter5.class) {
                if (Objects.isNull(counter)) {
                    counter = new Counter5();
                }
            }
        }
        return counter;
    }
}
