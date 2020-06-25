package com.madhouse.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-30 16:50
 */
@Slf4j
@Component
public class TaskMain {

    @Autowired
    private AsyncMethod asyncMethod;

    public void task() throws InterruptedException {
        log.info("任务开始");
        for (int i = 0; i < 10; i++) {
            asyncMethod.async(i);
        }
        log.info("任务结束");
    }

}
