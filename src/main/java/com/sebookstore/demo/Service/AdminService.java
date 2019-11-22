package com.sebookstore.demo.Service;

import com.sebookstore.demo.Entity.AdminUser;

public interface AdminService
{
    AdminUser findByAdminName(String adminName);
}
