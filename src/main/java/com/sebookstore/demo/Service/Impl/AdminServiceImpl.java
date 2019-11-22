package com.sebookstore.demo.Service.Impl;

import com.sebookstore.demo.Entity.AdminUser;
import com.sebookstore.demo.Repository.AdminRepository;
import com.sebookstore.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public AdminUser findByAdminName(String adminName)
    {
        return  adminRepository.findByAdminName(adminName);
    }
}
