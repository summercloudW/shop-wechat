package com.wy.shop.vo;

import com.wy.shop.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryListVo {

    private List<Category> categoryList;

}
