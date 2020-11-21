package com.shop.vo;

import com.shop.bo.IndexCategoryGoods;
import com.shop.entity.Banner;
import com.shop.entity.Category;
import com.shop.entity.Notice;
import lombok.Data;

import java.util.List;

@Data
public class IndexInfoVo {

    private List<Banner> banner;
    private List<IndexCategoryGoods> categoryList;
    private List<Category> channel;
    private List<Notice> notice;

}
