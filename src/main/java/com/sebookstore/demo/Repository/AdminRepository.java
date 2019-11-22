package com.sebookstore.demo.Repository;

import com.sebookstore.demo.Entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminUser,Long>
{
    AdminUser findByAdminName(String adminName);
}
