package com.wy.shop.service;


import com.wy.shop.entity.GoodsSpecification;

import java.util.List;

public interface GoodsSpecificationService {

    public List<GoodsSpecification> getGoodsSpecificationByGid(Integer goodsId);

    public String getSpecificationValueById(Integer goodsSpecificationId);

}
