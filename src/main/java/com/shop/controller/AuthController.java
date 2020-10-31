package com.shop.controller;

import com.shop.result.Result;
import com.shop.vo.IndexInfoVo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/loginByWeixin")
    @ResponseBody
    public Result<IndexInfoVo> checkLogin() {
        IndexInfoVo indexInfoVo = new IndexInfoVo();
        return Result.success(indexInfoVo);
    }

}
