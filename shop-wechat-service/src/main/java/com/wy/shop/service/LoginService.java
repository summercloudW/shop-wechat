package com.wy.shop.service;


import com.wy.shop.request.AuthInfoReq;
import com.wy.shop.vo.LoginVo;

public interface LoginService {


    public LoginVo doLogin(AuthInfoReq authInfoReq);

}
