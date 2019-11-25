package com.sebookstore.demo.Repository;

import com.sebookstore.demo.Entity.AdminUser;
import com.sebookstore.demo.Entity.JSUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JSRepository extends JpaRepository<JSUser,Long>
{
        JSUser findByJsName(String jsName);
        List<JSUser> findAll();
        JSUser findById(long id);
        List<JSUser> findAllByJsStatu(int jsStatu);

}
