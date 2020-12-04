package com.wy.shop.service.impl;

import com.wy.shop.mapper.KeywordsMapper;
import com.wy.shop.service.KeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/2  19:30
 */
@Service
public class KeywordsServiceImpl implements KeywordsService {

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Override
    public List<String> getKeywordList(String keyword) {
        return keywordsMapper.getKeywordList(keyword);
    }
}
