package com.wy.shop.service.impl;

import com.wy.shop.entity.ShowSettings;
import com.wy.shop.mapper.ShowSettingsMapper;
import com.wy.shop.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsServiceImpl implements SettingsService {

    @Autowired
    private ShowSettingsMapper showSettingsMapper;

    @Override
    public ShowSettings showSettings() {
        return showSettingsMapper.getShowSettings();
    }

}
