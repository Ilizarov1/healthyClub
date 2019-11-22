package com.sebookstore.demo.Service;

import com.sebookstore.demo.Entity.User;

import java.util.List;

public interface UserService
{
    User findByUserName(String userName);
    User findById(long id);
    void save(User user);
    List<User> findAll();
}
