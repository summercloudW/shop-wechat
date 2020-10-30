package com.shop.controller;

import com.shop.entity.Admin;
import com.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAdmin")
    @ResponseBody
    public Admin getAdmin() {
        Admin admin = adminService.getAdmin();
        return admin;
    }

}
