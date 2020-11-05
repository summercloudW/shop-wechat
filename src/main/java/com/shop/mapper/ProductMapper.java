package com.shop.mapper;

import com.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    public List<Product> getProductListByGid(Integer goods_id);

    public Product getProductById(Integer id);

}
