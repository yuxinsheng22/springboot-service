package com.madhouse.mq;

import com.madhouse.redis.RedisLock;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-15 09:34
 */
@Slf4j
@Component(value = "listener")
public class Listener implements ChannelAwareMessageListener {

    @Autowired
    private RedisLock redisLock;

    @Override
    public void onMessage(Message message, Channel channel) {
        byte[] body = message.getBody();
        String data = new String(body, StandardCharsets.UTF_8);
        String key = "lock:nx:" + data;
        while (true) {
            if (this.redisLock.tryLock(key)) {
                log.info("获得锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.redisLock.unlock(key);
                break;
            } else {
                log.info("未拿到锁");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
