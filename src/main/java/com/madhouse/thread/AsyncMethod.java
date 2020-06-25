package com.madhouse.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-30 16:46
 */
@Slf4j
@Component
public class AsyncMethod {

    @Async(value = "threadPoolTaskExecutor")
    public void async(int i) throws InterruptedException {
        long start = System.currentTimeMillis();
        log.info("线程ID[{}],线程名称[{}]", Thread.currentThread().getId(), Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        long end = System.currentTimeMillis();
        log.info("本次任务号[{}],执行花费时间[{}]", i, (end - start));
    }
}
