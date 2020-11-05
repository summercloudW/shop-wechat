package com.shop.mapper;

import com.shop.entity.GoodsSpecification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsSpecificationMapper {

    public List<GoodsSpecification> getGoodsSpecificationByGid(Integer goodsSpecificationId);

    public String getSpecificationValueById(Integer goodsSpecificationId);

}
