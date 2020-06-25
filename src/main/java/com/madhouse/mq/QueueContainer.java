package com.madhouse.mq;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-28 11:50
 */
@Component
public class QueueContainer {

    @Resource
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;

    /**
     * @desc: 判断监听器是否监听了指定的队列。
     * @author: yuxinsheng
     * @time: 2020-04-28 11:53
     */
    private boolean isQueueListener(String queueName, MessageListenerContainer listenerContainer) {
        if (listenerContainer instanceof AbstractMessageListenerContainer) {
            AbstractMessageListenerContainer abstractMessageListenerContainer = (AbstractMessageListenerContainer) listenerContainer;
            String[] queueNames = abstractMessageListenerContainer.getQueueNames();
            return ArrayUtils.contains(queueNames, queueName);
        }
        return false;
    }

    /**
     * @desc: 停止指定队列
     * @author: yuxinsheng
     * @time: 2020-04-28 11:54
     */
    public boolean stop(String queueName) {
        Collection<MessageListenerContainer> listenerContainers = this.rabbitListenerEndpointRegistry.getListenerContainers();
        for (MessageListenerContainer listenerContainer : listenerContainers) {
            if (this.isQueueListener(queueName, listenerContainer)) {
                listenerContainer.stop();
                return true;
            }
        }
        return false;
    }

    /**
     * @desc: 也可以获取到指定的监听，然后调用start方法，同stop类似。rabbitListenerEndpointRegistry.start()会启动所有监听，如果监听已启动则忽略
     * @author: yuxinsheng
     * @time: 2020-04-28 11:54
     */
    public void start() {
        this.rabbitListenerEndpointRegistry.start();
    }
}
