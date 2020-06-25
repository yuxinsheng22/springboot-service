package com.madhouse.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-28 13:55
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class QueueContainerTest {

    @Autowired
    private Producer producer;

    @Autowired
    private QueueContainer queueContainer;

    @Test
    public void sendTestMsg() {
        String msg = "k";
        for (int i = 0; i < 10; i++) {
            this.producer.sendMsg(msg);
        }
    }

    @Test
    public void stopQueueListener() {
        String queueName = "test.queue";
        this.queueContainer.stop(queueName);
    }

    @Test
    public void startAllQueue(){
        this.queueContainer.start();
    }
}
