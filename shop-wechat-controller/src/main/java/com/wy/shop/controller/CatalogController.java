package com.shop.controller;

import com.shop.entity.CatalogCategory;
import com.shop.entity.Category;
import com.shop.request.CatalogPageReq;
import com.shop.result.Result;
import com.shop.service.CatalogService;
import com.shop.vo.CatalogCurrentListVo;
import com.shop.vo.CategoryListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@Slf4j
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/currentlist")
    @ResponseBody
    public Result<CatalogCurrentListVo> getCurrentList(@RequestBody CatalogPageReq catalogPageReq) {
        log.error(">>>>>>>>>>>" + catalogPageReq);
        CatalogCurrentListVo currentList = catalogService.getCurrentList(catalogPageReq);
        return Result.success(currentList);
    }

    @GetMapping("/current")
    @ResponseBody
    public Result<CatalogCategory> getCatalogCategory(Integer id) {
        CatalogCategory catalogCategory = catalogService.getCatalogCategory(id);
        return Result.success(catalogCategory);
    }


    @GetMapping("/index")
    @ResponseBody
    public Result<CategoryListVo> getCatalogCategory() {
        List<Category> indexCatalogCategory = catalogService.getIndexCatalogCategory();
        CategoryListVo categoryListVo = new CategoryListVo();
        categoryListVo.setCategoryList(indexCatalogCategory);
        return Result.success(categoryListVo);
    }
}
