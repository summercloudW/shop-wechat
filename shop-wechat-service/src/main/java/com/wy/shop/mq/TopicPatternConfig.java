package com.wy.shop.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author : WangYB
 * @time: 2020/12/26  10:11
 */
@Configuration
public class TopicPatternConfig {

    public static final String COMMON_QUEUE = "common.queue";
    public static final String VIP_QUEUE = "vip.queue";
    public static final String MESSAGE_TOPIC_EXCHANGE = "message.topic.exchange";
    public static final String COMMON_ROUTING_KEY = "message.common";
    public static final String VIP_ROUTING_KEY = "message.*";


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(MESSAGE_TOPIC_EXCHANGE);
    }

    @Bean
    public Queue commonQueue() {
        return new Queue(COMMON_QUEUE);
    }

    @Bean
    public Queue vipQueue() {
        return new Queue(VIP_QUEUE);
    }

    @Bean
    public Binding commonBinding() {
        return BindingBuilder.bind(commonQueue()).to(topicExchange()).with(COMMON_ROUTING_KEY);
    }

    @Bean
    public Binding vipBinding() {
        return BindingBuilder.bind(vipQueue()).to(topicExchange()).with(VIP_ROUTING_KEY);
    }

}
