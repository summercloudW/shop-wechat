package com.wy.shop.controller;

import com.wy.shop.request.AuthInfoReq;
import com.wy.shop.result.Result;
import com.wy.shop.service.LoginService;
import com.wy.shop.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private LoginService loginService;
//    @Autowired
//    private LoginHandler loginHandler;

    @PostMapping("/loginByWeixin")
    @ResponseBody
    public Result<LoginVo> checkLogin(@RequestBody AuthInfoReq authInfoReq) {
        LoginVo loginVo = loginService.doLogin(authInfoReq);
        return Result.success(loginVo);
    }

}
