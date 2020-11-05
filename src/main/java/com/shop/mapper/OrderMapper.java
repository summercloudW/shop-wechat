package com.shop.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    public Integer getToPayOrderCount(Integer userId);

    public Integer getToDeliveryCount(Integer userId);

    public Integer getToReceiveOrderCount(Integer userId);

}
