package com.shop.service.impl;

import com.shop.entity.ShowSettings;
import com.shop.mapper.ShowSettingsMapper;
import com.shop.service.SettingsService;
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
