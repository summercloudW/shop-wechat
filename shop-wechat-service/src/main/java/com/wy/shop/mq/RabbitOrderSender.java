package com.wy.shop.mq;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangyibo
 */
@Component
public class RabbitOrderSender {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(Order order) {
        String orderStr = JSON.toJSONString(order);
        CorrelationData correlationData = new CorrelationData(order.getPay_id());
        rabbitTemplate.convertSendAndReceive(MqConfig.ORDER_DIRECT_EXCHANGE,
                                   MqConfig.ROUTING, orderStr);
    }

}
