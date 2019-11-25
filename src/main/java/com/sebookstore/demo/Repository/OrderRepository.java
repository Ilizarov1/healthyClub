package com.sebookstore.demo.Repository;

import com.sebookstore.demo.Entity.User;
import com.sebookstore.demo.Entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<UserOrder,Long>
{

    List<UserOrder> findByUserId(Long userId);
    List<UserOrder> findByJsId(Long jsId);
    List<UserOrder> findAll();
    List<UserOrder> findByHealthyitemId(Long healthyitemId);
    UserOrder findById(long Id);

    List<UserOrder> findAllByState(boolean state);
    List<UserOrder> findAllByType(String typpe);
}
