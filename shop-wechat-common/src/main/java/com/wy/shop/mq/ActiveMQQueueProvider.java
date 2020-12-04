package com.wy.shop.mq;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author : WangYB
 * @time: 2020/12/1  18:40
 */

/**
 * 点对点模式消息的提供端
 */
@Component
public class ActiveMQQueueProvider extends MqProvider<String> {

    @Override
    public void publish(String destination, String value) {
        TextMessage mqTextMessage = new ActiveMQTextMessage();
        try {
            mqTextMessage.setText(value);
        } catch (JMSException e) {
            e.printStackTrace();
        }

        super.jmsMessagingTemplate.convertAndSend(super.newQueueInstance(destination), mqTextMessage);
    }

}
