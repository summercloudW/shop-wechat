package com.wy.shop.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @author : WangYB
 * @time: 2020/12/1  18:33
 */
public abstract class MqProvider<T> {

    @Autowired
    protected JmsMessagingTemplate jmsMessagingTemplate;

    public abstract void publish(String destination, T object);

    public ActiveMQQueue newQueueInstance(String destination) {
        return new ActiveMQQueue(destination);
    }

    public ActiveMQTopic newTopicInstance(String destination) {
        return new ActiveMQTopic(destination);
    }

}
