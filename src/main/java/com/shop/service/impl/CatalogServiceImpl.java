package com.shop.service.impl;

import com.shop.entity.CatalogCategory;
import com.shop.entity.CatalogGoods;
import com.shop.entity.Category;
import com.shop.mapper.GoodsMapper;
import com.shop.request.CatalogPageReq;
import com.shop.service.CatalogService;
import com.shop.service.CategoryService;
import com.shop.vo.CatalogCurrentListVo;
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
