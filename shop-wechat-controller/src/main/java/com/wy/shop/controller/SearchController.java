package com.wy.shop.controller;

import com.wy.shop.service.GoodsService;
import com.wy.shop.service.KeywordsService;
import com.wy.shop.service.SearchContentService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/2  19:33
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private KeywordsService keywordsService;
    @Autowired
    private SearchContentService searchContentService;

    @GetMapping("/helper")
    @ResponseBody
    public List<String> getKeywordList(String keyword) {
        return keywordsService.getKeywordList(keyword);
    }

    @GetMapping("/init")
    public void initData() {
        try {
            searchContentService.addGoodsToEs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @GetMapping("/list")
    public List<Map<String, Object>> searchGoods(String keyword,
                            String sort,
                            String order,
                            String sales) throws IOException {
        List<Map<String, Object>> list = searchContentService.searchPages(keyword, 1, 20);
        return list;
    }

}
