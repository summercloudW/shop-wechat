package com.shop.service;

import com.shop.entity.User;
import com.shop.request.AuthInfoReq;
import com.shop.vo.LoginVo;

public interface LoginService {


    public LoginVo doLogin(AuthInfoReq authInfoReq);

}
