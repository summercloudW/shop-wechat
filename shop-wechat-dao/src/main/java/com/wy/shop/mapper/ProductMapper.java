package com.wy.shop.mapper;

import com.wy.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProductMapper {

    public List<Product> getProductListByGid(Integer goods_id);

    public Product getProductById(Integer id);

}
