package com.wy.shop.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;


/**
 * @author : WangYB
 * @time: 2020/11/28  15:10
 */
@Configuration
public class MessageQueueConfig {

    @Bean(name = "queue")
    public Queue getQueue() {
        return new ActiveMQQueue("nameQueue");
    }

}
