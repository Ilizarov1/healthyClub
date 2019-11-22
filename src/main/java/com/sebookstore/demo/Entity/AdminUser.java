package com.sebookstore.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AdminUser implements Serializable
{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String adminName;
    @Column
    private String adminPwd;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setAdminName(String adminName)
    {
        this.adminName = adminName;
    }

    public String getAdminName()
    {
        return adminName;
    }

    public String getAdminPwd()
    {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd)
    {
        this.adminPwd = adminPwd;
    }
}
