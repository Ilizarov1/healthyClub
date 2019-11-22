package com.sebookstore.demo.Repository;

import com.sebookstore.demo.Entity.HealthyItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthyItemRepository extends JpaRepository<HealthyItem,Long>
{
    List<HealthyItem> findAll();
    HealthyItem findById(long id);
    List<HealthyItem> findByJsName(String jsName);
    List<HealthyItem> findByJsId(long jsId);

}
