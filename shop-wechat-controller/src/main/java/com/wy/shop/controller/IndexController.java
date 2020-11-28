package com.wy.shop.controller;

import com.wy.shop.result.Result;
import com.wy.shop.service.IndexService;
import com.wy.shop.vo.IndexInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/appInfo")
    @ResponseBody
    public Result<IndexInfoVo> getIndexInfo() {
        IndexInfoVo indexInfo = indexService.getIndexInfo();
        return Result.success(indexInfo);
    }

}
