package com.wy.shop.service.impl;

import com.wy.shop.entity.Admin;
import com.wy.shop.handler.ApplicationContextListener;
import com.wy.shop.mapper.AdminMapper;
import com.wy.shop.service.AdminService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdmin() {
        Admin admin = adminMapper.getAdmin();
        return admin;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public void updateUsername() {
        adminMapper.updateUsername("kkkkkkkkkk");
        int k = 1 / 0;
        adminMapper.updateUsername("dddddddddd");
    }

    //@Transactional
    @Override
    public void update() {
        ApplicationContext applicationContext = ApplicationContextListener.getApplicationContext();
        AdminService adminService = applicationContext.getBean(AdminService.class);
        adminService.updateUsername();
    }


}
