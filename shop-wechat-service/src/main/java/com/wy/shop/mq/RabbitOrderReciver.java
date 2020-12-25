package com.wy.shop.mq;

import com.rabbitmq.client.Channel;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

/**
 * @author wangyibo
 */
@Component
public class RabbitOrderReciver {

    //配置监听的哪一个队列，同时在没有queue和exchange的情况下会去创建并建立绑定关系
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MqConfig.ORDER_DIRECT_QUEUE),
            exchange = @Exchange(name=MqConfig.ORDER_DIRECT_EXCHANGE),
            key = "order.*"
    )
    )
    @RabbitHandler
    public void onMessage(String orderStr) {
        System.out.println(orderStr);
    }
}
