package com.wy.shop.mapper;

import jdk.internal.dynalink.linker.LinkerServices;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/2  19:17
 */
@Mapper
@Component
public interface KeywordsMapper {

    public List<String> getKeywordList(String keyword);

}
