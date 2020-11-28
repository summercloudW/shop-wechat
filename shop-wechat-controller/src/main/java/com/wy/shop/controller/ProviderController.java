package com.wy.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private Queue queue;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @GetMapping("send")
    public void sendMessage(String name) {

        jmsMessagingTemplate.convertAndSend(queue, name);

    }


}
