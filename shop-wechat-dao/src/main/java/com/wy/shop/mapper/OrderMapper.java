package com.wy.shop.mapper;

import com.wy.shop.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper {

    public Integer getToPayOrderCount(Integer userId);

    public Integer getToDeliveryCount(Integer userId);

    public Integer getToReceiveOrderCount(Integer userId);

    public void submitOrder(@Param("order") Order order);

    public Integer queryRecentId();

    public Order getOrderByRecentId(Integer id);

}
