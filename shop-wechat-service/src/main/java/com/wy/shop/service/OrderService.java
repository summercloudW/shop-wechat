package com.wy.shop.service;


import com.wy.shop.entity.Order;
import com.wy.shop.request.AddressInfoReq;
import com.wy.shop.vo.OrderCountVo;

public interface OrderService {

    public OrderCountVo getOrderCount(Integer userid);

    public Order submitOrderInfo(Integer uid, AddressInfoReq addressInfoReq);

}
