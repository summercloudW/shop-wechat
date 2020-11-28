package com.wy.shop.controller;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.Address;
import com.wy.shop.entity.User;
import com.wy.shop.result.Result;
import com.wy.shop.service.AddressService;
import com.wy.shop.utils.JwtUtil;
import com.wy.shop.vo.AddressVo;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/11/9  15:32
 */
@RequestMapping("/address")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAddresses")
    @ResponseBody
    public Result<List<AddressVo>> getAddresses(@RequestHeader("X-Nideshop-Token") String token) {
        List<AddressVo> addresses = null;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String userStr = claims.getSubject();
            User user = JSON.parseObject(userStr, User.class);
            int uid = user.getId();
            addresses = addressService.getAddresses(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(addresses);
    }

    @GetMapping("/addressDetail")
    @ResponseBody
    public Result<Address> getDetailAddress(@RequestParam Integer id) {
        Address address = new Address();
        if (id == 0) {
            return Result.success(address);
        }
        address = addressService.findAddressById(id);
        return Result.success(address);
    }

    @PostMapping("/saveAddress")
    @ResponseBody
    public Result<Address> saveAddress(@RequestHeader("X-Nideshop-Token") String token,@RequestBody Address address) {
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String userStr = claims.getSubject();
            User user = JSON.parseObject(userStr, User.class);
            int uid = user.getId();
            address.setUser_id(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Address recentAddress = addressService.saveAddress(address);
        return Result.success(recentAddress);
    }

}
