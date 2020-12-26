package com.wy.shop.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : WangYB
 * @time: 2020/12/26  10:48
 */
@Component
@RabbitListener(queues = TopicPatternConfig.COMMON_QUEUE)
public class CommonMessageReceiver {

    @RabbitHandler
    public void process(String orderStr) {
        System.out.println("common:"+orderStr);
    }

}
