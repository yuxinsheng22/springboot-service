package com.madhouse.singleton;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020/6/22 15:34
 */
public class CounterTest {
    public static void main(String[] args) {
        new Thread(() -> {
            Counter7 counter = Counter7.getInstance();
            System.out.println(counter.hashCode());
        }).start();

        new Thread(() -> {
            Counter7 counter = Counter7.getInstance();
            System.out.println(counter.hashCode());

        }).start();

    }
}
