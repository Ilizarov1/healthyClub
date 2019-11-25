package com.sebookstore.demo.Service.Impl;

import com.sebookstore.demo.Entity.UserOrder;
import com.sebookstore.demo.Repository.OrderRepository;
import com.sebookstore.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<UserOrder> findByUserId(long userId)
    {
        return orderRepository.findByUserId(userId);
    }
    @Override
    public List<UserOrder> findByHealthyitemId(long healthyitemId)
    {
        return orderRepository.findByHealthyitemId(healthyitemId);
    }
    @Override
    public UserOrder save(UserOrder userOrder){ return orderRepository.save(userOrder);}

    @Override
    public UserOrder findById(long Id){return orderRepository.findById(Id);}
    @Override
    public List<UserOrder> findAll()
    {
        return orderRepository.findAll();
    }
    @Override
    public List<UserOrder> findByJsId(long jsId)
    {
        return orderRepository.findByJsId(jsId);
    }

    @Override
    public List<UserOrder> findAllByState(boolean state){return orderRepository.findAllByState(state);}
    @Override
    public List<UserOrder> findAllByType(String type){return orderRepository.findAllByType(type);}

}
