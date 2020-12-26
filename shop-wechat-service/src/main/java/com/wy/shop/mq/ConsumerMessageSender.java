package com.wy.shop.mq;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : WangYB
 * @time: 2020/12/26  10:42
 */
@Component
public class ConsumerMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    //回调函数: confirm确认
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("correlationData: " + correlationData.getId());
            String messageId = correlationData.getId();
            if(ack){
                //如果confirm返回成功 则进行更新
                System.out.println("confirm返回成功 则进行更新");
            } else {
                //失败则进行具体的后续操作:重试 或者补偿等手段
                System.err.println("异常处理...");
            }
        }
    };


    public void publishMessage(Order order) {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        String orderStr = JSON.toJSONString(order);
        CorrelationData correlationData = new CorrelationData(order.getPay_id());
        rabbitTemplate.convertAndSend(TopicPatternConfig.MESSAGE_TOPIC_EXCHANGE,
                                      TopicPatternConfig.VIP_ROUTING_KEY,
                                      orderStr, correlationData);
    }

}
