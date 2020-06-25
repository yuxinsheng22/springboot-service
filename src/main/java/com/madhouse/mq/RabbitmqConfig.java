package com.madhouse.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Desc:
 * @Author: yuxinsheng
 * @CreatedDate: 2020-02-27 10:50
 */
@Slf4j
@Configuration
public class RabbitmqConfig {

    @Autowired
    private Environment env;

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer;

    @Autowired
    private Listener listener;


//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
//        connectionFactory.setPublisherReturns(true);
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
////            if (ack) {
////                log.info("消息发送成功:correlationData[{}]", correlationData.getId());
////            } else {
////                log.info("消息发送失败:correlationData[{}],cause[{}]", correlationData.getId(), cause);
////            }
//            if(!ack){
//                log.info("消息发送失败:correlationData[{}],cause[{}]", correlationData.getId(), cause);
//            }
//        });
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> log.info("消息路由队列失败:exchange[{}],route[{}],replyCode[{}],replyText[{}],message:[{}]", exchange, routingKey, replyCode, replyText, message.getBody().toString()));
//        return rabbitTemplate;
//    }


//    @Bean
//    public SimpleMessageListenerContainer listenerContainer(@Qualifier(value = "testQueue") Queue tweetQueue) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        //并发配置
//        container.setConcurrentConsumers(Objects.requireNonNull(env.getProperty("spring.rabbitmq.listener.simple.concurrency", Integer.class)));
//        container.setMaxConcurrentConsumers(Objects.requireNonNull(env.getProperty("spring.rabbitmq.listener.simple.max-concurrency", Integer.class)));
//        container.setPrefetchCount(Objects.requireNonNull(env.getProperty("spring.rabbitmq.listener.simple.prefetch", Integer.class)));
//        //接收消息确认机制
//        container.setQueues(tweetQueue);
//        container.setMessageListener(listener);
//        return container;
//    }


//    @Bean(name = "multiListenerContainer")
//    public SimpleRabbitListenerContainerFactory multiListenerContainer() {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factoryConfigurer.configure(factory, connectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
////        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
//        factory.setConcurrentConsumers(env.getProperty("spring.rabbitmq.listener.simple.concurrency", Integer.class));
//        factory.setMaxConcurrentConsumers(env.getProperty("spring.rabbitmq.listener.simple.max-concurrency", Integer.class));
//        factory.setPrefetchCount(env.getProperty("spring.rabbitmq.listener.simple.prefetch", Integer.class));
//        return factory;
//    }


}
