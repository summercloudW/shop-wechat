package com.shop.service.impl;

import com.shop.mapper.OrderMapper;
import com.shop.service.OrderService;
import com.shop.vo.OrderCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderCountVo getOrderCount(Integer userid) {
        Integer toDeliveryCount = orderMapper.getToDeliveryCount(userid);
        Integer toPayOrderCount = orderMapper.getToPayOrderCount(userid);
        Integer toReceiveOrderCount = orderMapper.getToReceiveOrderCount(userid);

        OrderCountVo orderCountVo = new OrderCountVo();
        orderCountVo.setToDelivery(toDeliveryCount);
        orderCountVo.setToPay(toPayOrderCount);
        orderCountVo.setToReceive(toReceiveOrderCount);

        return orderCountVo;
    }

}
