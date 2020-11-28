package com.wy.shop.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @author : WangYB
 * @time: 2020/11/27  16:54
 */
@Configuration
@EnableStateMachine
public class OrderStateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderStatus, OrderEvent> {

    /**
     *
     * 初始化状态机的状态
     * @param states
     * @throws Exception
     *
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderEvent> states) throws Exception {
        states.withStates()
                .initial(OrderStatus.UN_PAY)
                .states(EnumSet.allOf(OrderStatus.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderEvent> transitions) throws Exception {
        transitions
                //触发支付事件
                .withExternal()
                .source(OrderStatus.UN_PAY)
                .target(OrderStatus.PAYED)
                .event(OrderEvent.PAY)
                .and()

                // 用户取消支付
                .withExternal()
                .source(OrderStatus.UN_PAY)
                .target(OrderStatus.CANCELLED_BY_USER)
                .event(OrderEvent.USER_CANCELLED)
                .and()

                // 系统取消订单
                .withExternal()
                .source(OrderStatus.UN_PAY)
                .target(OrderStatus.CANCELLED_BY_SYSTEM)
                .event(OrderEvent.SYSTEM_CANCELLED)
                .and()

                //支付后退款
                .withExternal()
                .source(OrderStatus.PAYED)
                .target(OrderStatus.REFUNDING)
                .event(OrderEvent.REFUND)
                .and()

                //退款成功
                .withExternal()
                .source(OrderStatus.REFUNDING)
                .target(OrderStatus.REFUNDED)
                .event(OrderEvent.CHECK_REFUND)
                .and()

                //已发货
                .withExternal()
                .source(OrderStatus.PAYED)
                .target(OrderStatus.SHIP)
                .event(OrderEvent.SHIP)
                .and()

                //用户确认收货
                .withExternal()
                .source(OrderStatus.SHIP)
                .target(OrderStatus.USER_RECEIVED)
                .event(OrderEvent.USER_RECEIVE)
                .and()

                //系统确认收货
                .withExternal()
                .source(OrderStatus.USER_RECEIVED)
                .target(OrderStatus.SYSTEM_RECEIVED)
                .event(OrderEvent.PAY);

    }

}
