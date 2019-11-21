package com.sebookstore.demo.Service;

import com.sebookstore.demo.Entity.JSUser;

import java.util.List;

public interface JSService
{
    JSUser findByJsName(String jsName);
    List<JSUser> findAll();
}
