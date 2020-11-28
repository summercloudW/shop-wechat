package com.wy.shop.controller;

import com.wy.shop.entity.Region;
import com.wy.shop.result.Result;
import com.wy.shop.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/11/9  16:17
 */
@RequestMapping("/region")
@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<Region>> getDetailAddress(@RequestParam Integer parentId) {
        List<Region> regionList = new ArrayList<>();
        if (parentId == 0) {
            return Result.success(regionList);
        }
        regionList = regionService.findRegionListByPid(parentId);
        return Result.success(regionList);
    }



}
