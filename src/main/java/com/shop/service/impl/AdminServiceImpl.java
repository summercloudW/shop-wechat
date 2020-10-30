package com.shop.service.impl;

import com.shop.entity.Admin;
import com.shop.mapper.AdminMapper;
import com.shop.service.AdminService;
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
