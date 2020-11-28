package com.wy.shop.service.impl;

import com.wy.shop.entity.*;
import com.wy.shop.service.*;
import com.wy.shop.vo.IndexInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class IndexServiceImpl implements IndexService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private NoticeService noticeService;



    @Override
    public IndexInfoVo getIndexInfo() {

        IndexInfoVo indexInfoVo = new IndexInfoVo();

        List<IndexCategoryGoods> indexCategoryGoodsList = new ArrayList<IndexCategoryGoods>();
        List<Category> channel = categoryService.getChannel();
        List<Notice> noticeList = noticeService.getListNotice();
        List<Banner> bannerList = bannerService.getBannerList();

        log.info(bannerList+">>>>>>>>>>>>>>");

        for (Category category : channel) {
            IndexCategoryGoods indexCategoryGoods = new IndexCategoryGoods();
            int id = category.getId();
            indexCategoryGoods.setName(category.getName());
            indexCategoryGoods.setId(id);
            List<Goods> goodsList = goodsService.getGoodsByCategoryId(id);
            indexCategoryGoods.setGoodsList(goodsList);
            indexCategoryGoods.setBanner(category.getImg_url());
            indexCategoryGoods.setHeight(category.getP_height());
            indexCategoryGoodsList.add(indexCategoryGoods);
        }

        indexInfoVo.setBanner(bannerList);
        indexInfoVo.setCategoryList(indexCategoryGoodsList);
        indexInfoVo.setChannel(channel);
        indexInfoVo.setNotice(noticeList);

        return indexInfoVo;
    }

}
