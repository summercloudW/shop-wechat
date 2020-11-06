package com.shop.service;

import com.shop.entity.GoodsSpecification;

import java.util.List;

public interface GoodsSpecificationService {

    public GoodsSpecification getGoodsSpecificationByPid(Integer goodsSpecificationId);

    public String getSpecificationValueById(Integer goodsSpecificationId);

}
