package com.wy.shop.controller;

import com.wy.shop.mq.ActiveMQQueueConstants;
import com.wy.shop.mq.ActiveMQQueueProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @author : WangYB
 * @time: 2020/11/28  15:15
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ActiveMQQueueProvider activeMQQueueProvider;

    @GetMapping("send")
    public void sendMessage(String tasKId) {
        activeMQQueueProvider.publish(ActiveMQQueueConstants.QUEUE_ORDER_AUTO_TASK, tasKId);
    }

    @GetMapping("/test")
    @ResponseBody
    public void exceptionTest() {
        String s = null;
        boolean sss = s.equals("sss");
        System.out.println(sss);
        Integer.valueOf("dddddddddddddddd12dddddd");
    }

}
