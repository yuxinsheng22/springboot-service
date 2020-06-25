package com.madhouse.mq;

import com.madhouse.redis.RedisLock;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-26 09:11
 */
@Slf4j
@Component
public class TestListener2 implements ChannelAwareMessageListener {

    private static final String KEY_PREFIX = "springboot_demo:queue_lock2:";

    @Autowired
    private RedisLock redisLock;


    @Override
    @RabbitHandler
    @RabbitListener(queues = "test2.queue")
    public void onMessage(Message message, Channel channel) {
        byte[] body = message.getBody();
        String data = new String(body, StandardCharsets.UTF_8);
        String key = KEY_PREFIX + data;
        while (true) {
            if (redisLock.tryLock(key)) {
                try {
                    log.info("test2-获得锁,当前线程号[{}]", Thread.currentThread().getId());
                    TimeUnit.SECONDS.sleep(2);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    log.info("test2-解锁,当前线程号[{}]", Thread.currentThread().getId());
                    redisLock.unlock(key);
                }
            } else {
                log.info("test2-没有获得锁,当前线程号[{}]", Thread.currentThread().getId());
            }
        }
    }

}
