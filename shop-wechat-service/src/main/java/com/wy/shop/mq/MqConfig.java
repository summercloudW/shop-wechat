package com.wy.shop.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author wangyibo
 */
@Component
public class MqConfig {

    public static final String ORDER_DIRECT_EXCHANGE = "order.direct.exchange";
    public static final String ORDER_DIRECT_QUEUE = "order.direct.queue";
    public static final String ROUTING = "order.first";


    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(ORDER_DIRECT_EXCHANGE);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue(ORDER_DIRECT_QUEUE);
    }

    @Bean
    public Binding binding(Queue orderQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(orderQueue).to(directExchange).with(MqConfig.ROUTING);
    }



}
