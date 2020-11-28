package com.wy.shop.service.impl;

import com.wy.shop.entity.GoodsSpecification;
import com.wy.shop.mapper.GoodsSpecificationMapper;
import com.wy.shop.service.GoodsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsSpecificationServiceImpl implements GoodsSpecificationService {

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;


    @Override
    public List<GoodsSpecification> getGoodsSpecificationByGid(Integer goodsId) {
        return goodsSpecificationMapper.getGoodsSpecificationByGid(goodsId);
    }

    @Override
    public String getSpecificationValueById(Integer goodsSpecificationId) {
        return goodsSpecificationMapper.getSpecificationValueById(goodsSpecificationId);
    }

}
