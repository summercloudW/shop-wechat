package com.wy.shop.mapper;

import com.wy.shop.entity.GoodsSpecification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GoodsSpecificationMapper {

    public List<GoodsSpecification> getGoodsSpecificationByGid(Integer goodsId);

    public String getSpecificationValueById(Integer goodsSpecificationId);

}
