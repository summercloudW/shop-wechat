package com.shop.service;

import com.shop.entity.GoodsSpecification;

import java.util.List;

public interface GoodsSpecificationService {

    public List<GoodsSpecification> getGoodsSpecificationByGid(Integer goodsId);

    public String getSpecificationValueById(Integer goodsSpecificationId);

}
