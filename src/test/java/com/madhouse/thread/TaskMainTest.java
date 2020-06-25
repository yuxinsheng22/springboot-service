package com.madhouse.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-30 16:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMainTest {

    @Autowired
    private TaskMain taskMain;

    @Test
    public void taskTest() throws InterruptedException {
        this.taskMain.task();
    }
}
