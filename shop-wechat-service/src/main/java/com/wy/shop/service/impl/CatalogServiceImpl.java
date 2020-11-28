package com.wy.shop.service.impl;

import com.wy.shop.entity.CatalogCategory;
import com.wy.shop.entity.CatalogGoods;
import com.wy.shop.entity.Category;
import com.wy.shop.mapper.GoodsMapper;
import com.wy.shop.request.CatalogPageReq;
import com.wy.shop.service.CatalogService;
import com.wy.shop.service.CategoryService;
import com.wy.shop.vo.CatalogCurrentListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private CategoryService categoryService;

    @Override
    public CatalogCurrentListVo getCurrentList(CatalogPageReq catalogPageReq) {
        int goodsCount = goodsMapper.getGoodsCount();
        int totalPage = (goodsCount - 1) / catalogPageReq.getSize() + 1;
        List<CatalogGoods> catalogGoodsList = goodsMapper.getCatalogGoods(catalogPageReq.getPage() * catalogPageReq.getSize(), catalogPageReq.getSize(), catalogPageReq.getId());
        CatalogCurrentListVo catalogCurrentListVo = new CatalogCurrentListVo();
        catalogCurrentListVo.setCount(goodsCount);
        catalogCurrentListVo.setCurrentPage(catalogPageReq.getPage());
        catalogCurrentListVo.setData(catalogGoodsList);
        catalogCurrentListVo.setPageSize(catalogPageReq.getSize());
        catalogCurrentListVo.setTotalPages(totalPage);
        return catalogCurrentListVo;
    }

    @Override
    public CatalogCategory getCatalogCategory(Integer id) {
        return categoryService.getCatalogCategory(id);
    }

    @Override
    public List<Category> getIndexCatalogCategory() {
        return categoryService.getIndexCatalogCategory();
    }

}
