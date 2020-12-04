package com.wy.shop.controller;

import com.wy.shop.service.KeywordsService;
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

    @GetMapping("/helper")
    @ResponseBody
    public List<String> getKeywordList(String keyword) {
        return keywordsService.getKeywordList(keyword);
    }



}
