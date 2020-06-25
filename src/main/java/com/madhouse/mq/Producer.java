package com.madhouse.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @Desc:
 * @Author: yuxinsheng
 * @CreatedDate: 2020-02-28 15:34
 */
@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    public void sendMsg(String msg) {
        this.rabbitTemplate.setExchange(env.getProperty("test.exchange.name"));
        this.rabbitTemplate.setRoutingKey(env.getProperty("test.routing.key.name"));
        Message message = MessageBuilder.withBody(msg.getBytes(StandardCharsets.UTF_8)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        this.rabbitTemplate.send(message);
    }

    public void sendTweetMsg(String msg) {
        this.rabbitTemplate.setExchange(env.getProperty("tw.tweet.exchange.name"));
        this.rabbitTemplate.setRoutingKey(env.getProperty("tw.tweet.routing.key.name"));
        Message message = MessageBuilder.withBody(msg.getBytes(StandardCharsets.UTF_8)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        this.rabbitTemplate.send(message);
    }

    public void sendRetweetMsg(String msg) {
        this.rabbitTemplate.setExchange(env.getProperty("tw_retweet.exchange.name"));
        this.rabbitTemplate.setRoutingKey(env.getProperty("tw_retweet.routing.key.name"));
        Message message = MessageBuilder.withBody(msg.getBytes(StandardCharsets.UTF_8)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        this.rabbitTemplate.send(message);
    }
}
