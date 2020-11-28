package com.wy.shop.mapper;

import com.wy.shop.entity.ShowSettings;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ShowSettingsMapper {

    public ShowSettings getShowSettings();

}
