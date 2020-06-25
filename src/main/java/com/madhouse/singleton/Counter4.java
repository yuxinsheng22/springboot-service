package com.madhouse.singleton;

import java.util.Objects;

/**
 * @desc: 懒汉式:线程不安全(会发生指令重排序)
 * @author: yuxinsheng
 * @date: 2020/6/22 15:26
 */
public class Counter4 {

    private static Counter4 counter = null;

    private Counter4() {
        System.out.println("私有构造器");
    }

    public static Counter4 getInstance() {
        if (Objects.isNull(counter)) {
            synchronized (Counter4.class) {
                if (Objects.isNull(counter)) {
                    counter = new Counter4();
                }
            }
        }
        return counter;
    }
}
