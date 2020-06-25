package com.madhouse.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-27 16:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class publisherTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Sender sender;

    @Test
    public void send1() {
        String msg = "abc";
//        this.rabbitTemplate.setExchange("test.exchange");
//        this.rabbitTemplate.setRoutingKey("test.routing.key1");
        Message message = MessageBuilder.withBody(msg.getBytes(StandardCharsets.UTF_8)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.send(message);
        this.rabbitTemplate.send("test.exchange1", "test.routing.key", message, correlationData);
    }

    @Test
    public void listenerMsgConfirmSender() {
        String msg = "abc";
        this.rabbitTemplate.setExchange("listener.msg.confirm.exchange");
        this.rabbitTemplate.setRoutingKey("listener.msg.confirm.routing.key");
        Message message = MessageBuilder.withBody(msg.getBytes(StandardCharsets.UTF_8)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.send(message);
    }

    @Test
    public void send() {
        String msg = "abc";
        this.sender.sendMsg(msg);
    }
}
