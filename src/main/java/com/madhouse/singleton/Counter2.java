package com.madhouse.singleton;

import java.util.Objects;

/**
 * @desc: 懒汉式:线程安全
 * @author: yuxinsheng
 * @date: 2020/6/22 15:26
 */
public class Counter2 {

    private static Counter2 counter;

    private Counter2() {
        System.out.println("私有构造器");
    }

    public synchronized static Counter2 getInstance() {
        if (Objects.isNull(counter)) {
            counter = new Counter2();
        }
        return counter;
    }
}
