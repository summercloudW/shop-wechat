package com.wy.shop.controller;

import com.wy.shop.entity.ShowSettings;
import com.wy.shop.result.Result;
import com.wy.shop.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/settings")
@RestController
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @GetMapping("/showSettings")
    @ResponseBody
    public Result<ShowSettings> showSettings() {
        ShowSettings showSettings = settingsService.showSettings();
        return Result.success(showSettings);
    }

}
