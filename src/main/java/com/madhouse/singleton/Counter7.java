package com.madhouse.singleton;

/**
 * @desc: 枚举模式：最安全
 * @author: yuxinsheng
 * @date: 2020/6/22 15:26
 */
public class Counter7 {

    private Counter7() {
    }

    public static Counter7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private Counter7 counter;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            counter = new Counter7();
        }

        public Counter7 getInstance() {
            return counter;
        }
    }
}
