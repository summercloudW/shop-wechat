package com.shop.controller;

import com.shop.entity.User;
import com.shop.handler.LoginHandler;
import com.shop.request.AuthInfoReq;
import com.shop.result.Result;
import com.shop.service.LoginService;
import com.shop.util.MyBase64;
import com.shop.vo.IndexInfoVo;
import com.shop.vo.LoginVo;
import com.shop.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginHandler loginHandler;

    @PostMapping("/loginByWeixin")
    @ResponseBody
    public Result<LoginVo> checkLogin(@RequestBody AuthInfoReq authInfoReq) {
        LoginVo loginVo = loginService.doLogin(authInfoReq);
        return Result.success(loginVo);
    }

}
