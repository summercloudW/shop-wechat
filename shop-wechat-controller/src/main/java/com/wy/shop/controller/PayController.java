package com.wy.shop.controller;

import com.wy.shop.result.CodeMsg;
import com.wy.shop.result.Result;
import com.wy.shop.statemachine.OrderEvent;
import com.wy.shop.statemachine.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : WangYB
 * @time: 2020/11/27  14:31
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    public static final Logger log = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private StateMachine<OrderStatus, OrderEvent> stateMachine;

    @GetMapping("/preWeixinPay")
    public Result payBuWeiXin(@RequestParam("orderId") Integer orderId) {
        stateMachine.start();
        stateMachine.sendEvent(OrderEvent.CHECK_REFUND);
        stateMachine.sendEvent(OrderEvent.PAY);
        stateMachine.sendEvent(OrderEvent.SHIP);
        OrderStatus orderStatus = stateMachine.getState().getId();
        log.info(">>>>>>>>>>>>>>>>>>" + orderStatus);
        return Result.error(CodeMsg.PAY_FAILURE);
    }

}
