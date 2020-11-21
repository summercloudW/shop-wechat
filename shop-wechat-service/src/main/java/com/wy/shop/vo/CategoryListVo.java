package com.shop.vo;

import com.shop.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryListVo {

    private List<Category> categoryList;

}
