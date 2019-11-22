package com.sebookstore.demo.Service.Impl;

import com.sebookstore.demo.Entity.HealthyItem;
import com.sebookstore.demo.Repository.HealthyItemRepository;
import com.sebookstore.demo.Service.HealthyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HealthyItemServiceImpl implements HealthyItemService
{
    @Autowired
    private HealthyItemRepository healthyItemRepository;
  //  @Override
  //  public List<HealthyItem> findByJsName(String jsName){ return healthyItemRepository.findByJsName(jsName); }
    @Override
    public List<HealthyItem> findAll()
    {
      return  healthyItemRepository.findAll();
    }
    @Override
    public HealthyItem findById(long id)
    {
        return healthyItemRepository.findById(id);
    }
    @Override
    public HealthyItem save(HealthyItem healthyItem)
    {
        return healthyItemRepository.save(healthyItem);
    }
    @Override
    public List<HealthyItem> findByJsId(long jsId){ return healthyItemRepository.findByJsId(jsId); }

}
