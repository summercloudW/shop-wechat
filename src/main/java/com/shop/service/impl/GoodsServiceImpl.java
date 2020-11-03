package com.shop.service.impl;

import com.shop.bo.SpecificationList;
import com.shop.entity.Goods;
import com.shop.entity.GoodsSpecification;
import com.shop.entity.Product;
import com.shop.entity.Specification;
import com.shop.mapper.GoodsMapper;
import com.shop.service.*;
import com.shop.vo.DetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private ProductService productService;
    @Autowired
    GoodsSpecificationService goodsSpecificationService;
    @Autowired
    SpecificationService specificationService;

    @Override
    public Integer getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }

    @Override
    public List<Goods> getGoodsByCategoryId(Integer category_id) {
        return goodsMapper.getGoodsByCategoryId(category_id);
    }

    @Override
    public DetailVo getDetailInfo(Integer goods_id) {
        DetailVo detailVo = new DetailVo();
        List<Product> productList = productService.getProductListByGid(goods_id);

        String goods_specification_ids = productList.get(0).getGoods_specification_ids();
        int specification_ids = Integer.parseInt(goods_specification_ids);
        List<GoodsSpecification> goodsSpecifications = goodsSpecificationService.getGoodsSpecificationByGid(specification_ids);

        //通过商品的具体信息id来获取具体信息
        int specification_id = goodsSpecifications.get(0).getSpecification_id();
        Specification specification = specificationService.getSpecification(specification_id);
        SpecificationList specificationList = new SpecificationList();
        specificationList.setValueList(goodsSpecifications);
        specificationList.setName(specification.getName());
        specificationList.setSpecification_id(specification.getId());

        //为vo赋值
        detailVo.setInfo(goodsMapper.getSpecificationGoods(goods_id));
        detailVo.setGallery(galleryService.getSpecificationGallery(goods_id));
        detailVo.setProductList(productList);
        detailVo.setSpecificationList(specificationList);
        return detailVo;
    }

}
