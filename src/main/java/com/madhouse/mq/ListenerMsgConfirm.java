package com.madhouse.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020/6/22 09:55
 */
@Slf4j
@Component
public class ListenerMsgConfirm implements ChannelAwareMessageListener {

    @Override
    @RabbitListener(queues = "${listener.msg.confirm.queue.name}")
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            int a = 1 / 0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            System.out.println("消费消息确认" + message.getMessageProperties().getConsumerQueue() + "，接收到了回调方法");
        } catch (Exception e) {
//            if(e instanceof NullPointerException){
//                log.error("消费消息异常", e);
//                channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
//            }else {
//                log.warn("尽管消费消息出现异常,但是选择不处理,并告知rabbit,已经确认消费消息");
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
//            }
            //重新回到队列
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            log.info("deliveryTag[{}]", deliveryTag);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            System.out.println("尝试重发：" + message.getMessageProperties().getConsumerQueue());
            //requeue =true 重回队列，false 丢弃
        }
    }
}
