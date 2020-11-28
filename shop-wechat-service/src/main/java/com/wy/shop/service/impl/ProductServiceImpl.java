package com.wy.shop.service.impl;

import com.wy.shop.entity.Product;
import com.wy.shop.mapper.ProductMapper;
import com.wy.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductListByGid(Integer goods_id) {
        return productMapper.getProductListByGid(goods_id);
    }

    @Override
    public Product getProductById(Integer id) {
        return productMapper.getProductById(id);
    }

}
