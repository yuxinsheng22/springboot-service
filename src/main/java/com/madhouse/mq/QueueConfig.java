package com.madhouse.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-25 21:19
 */
@Configuration
public class QueueConfig {

    @Autowired
    private Environment env;


    @Bean(name = "testQueue")
    public Queue queue() {
        return new Queue(Objects.requireNonNull(env.getProperty("test.queue.name")), true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Objects.requireNonNull(env.getProperty("test.exchange.name")), true, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(Objects.requireNonNull(env.getProperty("test.routing.key.name")));
    }

    @Bean(name = "testQueue2")
    public Queue queue2() {
        return new Queue("test2.queue", true);
    }

    @Bean
    public TopicExchange exchange2() {
        return new TopicExchange("test2.exchange", true, false);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(exchange2()).with("test2.routing.key");
    }

    @Bean
    public Queue listenerMsgConfirmQueue() {
        return new Queue("listener.msg.confirm.queue", true);
    }

    @Bean
    public TopicExchange listenerMsgConfirmExchange() {
        return new TopicExchange("listener.msg.confirm.exchange", true, false);
    }

    @Bean
    public Binding listenerMsgConfirmBinding() {
        return BindingBuilder.bind(listenerMsgConfirmQueue()).to(listenerMsgConfirmExchange()).with("listener.msg.confirm.routing.key");
    }
}
