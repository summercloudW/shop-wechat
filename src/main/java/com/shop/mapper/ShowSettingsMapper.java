package com.shop.mapper;

import com.shop.entity.ShowSettings;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShowSettingsMapper {

    @Select("SELECT * FROM hiolabs_show_settings")
    public ShowSettings getShowSettings();

}
