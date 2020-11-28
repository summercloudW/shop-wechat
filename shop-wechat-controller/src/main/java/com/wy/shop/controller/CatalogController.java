package com.wy.shop.controller;

import com.wy.shop.entity.CatalogCategory;
import com.wy.shop.entity.Category;
import com.wy.shop.request.CatalogPageReq;
import com.wy.shop.result.Result;
import com.wy.shop.service.CatalogService;
import com.wy.shop.vo.CatalogCurrentListVo;
import com.wy.shop.vo.CategoryListVo;
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
