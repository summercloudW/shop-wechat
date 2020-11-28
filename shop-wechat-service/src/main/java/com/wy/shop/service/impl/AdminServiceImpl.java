package com.wy.shop.service.impl;

import com.wy.shop.entity.Admin;
import com.wy.shop.mapper.AdminMapper;
import com.wy.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdmin() {
        Admin admin = adminMapper.getAdmin();
        return admin;
    }

}
