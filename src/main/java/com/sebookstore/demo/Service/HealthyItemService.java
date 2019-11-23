package com.sebookstore.demo.Service;

import com.sebookstore.demo.Entity.HealthyItem;

import java.util.List;

public interface HealthyItemService
{
    List<HealthyItem> findAll();
    HealthyItem findById(long id);
    HealthyItem save(HealthyItem healthyItem);
    //List<HealthyItem> findByJsName(String jsName);
    List<HealthyItem> findByJsId(long jsId);
}
