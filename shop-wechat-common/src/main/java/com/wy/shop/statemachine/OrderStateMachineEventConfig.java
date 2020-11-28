package com.wy.shop.statemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author : WangYB
 * @time: 2020/11/28  09:08
 */
@WithStateMachine
public class OrderStateMachineEventConfig {

    public static final Logger log = LoggerFactory.getLogger(OrderStateMachineEventConfig.class);

    @OnTransition(source = "UN_PAY", target = "PAYED")
    public void pay() {
        log.info("开始支付");
    }


    @OnTransition(source = "UN_PAY", target = "CANCELLED_BY_USER")
    public void cancelledByUser() {

    }

    @OnTransition(source = "UN_PAY", target = "CANCELLED_BY_SYSTEM")
    public void cancelledBySystem() {

    }


    @OnTransition(source = "PAYED", target = "REFUNDING")
    public void refund() {

    }

    @OnTransition(source = "REFUNDING", target = "REFUNDED")
    public void checkRefund() {
        log.info("退款成功");

    }

    @OnTransition(source = "PAYED", target = "SHIP")
    public void ship() {

    }

    @OnTransition(source = "SHIP",target = "USER_RECEIVED")
    public void receiveByUser() {

    }

    @OnTransition(source = "USER_RECEIVED", target = "SYSTEM_RECEIVED")
    public void receiveBySystem() {

    }


}
