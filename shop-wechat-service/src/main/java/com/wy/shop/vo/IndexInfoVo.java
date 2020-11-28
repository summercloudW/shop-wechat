package com.wy.shop.vo;

import com.wy.shop.entity.Banner;
import com.wy.shop.entity.Category;
import com.wy.shop.entity.IndexCategoryGoods;
import com.wy.shop.entity.Notice;
import lombok.Data;

import java.util.List;

@Data
public class IndexInfoVo {

    private List<Banner> banner;
    private List<IndexCategoryGoods> categoryList;
    private List<Category> channel;
    private List<Notice> notice;

}
