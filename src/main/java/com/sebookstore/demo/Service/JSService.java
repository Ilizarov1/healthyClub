package com.sebookstore.demo.Service;

import com.sebookstore.demo.Entity.JSUser;

import java.util.List;

public interface JSService
{
    JSUser findByJsName(String jsName);
    JSUser findById(long id);
    List<JSUser> findAll();
    JSUser save(JSUser jsUser);
    List<JSUser> findAllByJsStatu(int jsStatu);

}
