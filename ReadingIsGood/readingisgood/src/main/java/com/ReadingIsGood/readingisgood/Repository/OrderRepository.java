package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository  extends JpaRepository<OrderEntity,Long> {


    public List<OrderEntity> getOrderEntitiesByCustomer_id(Long id);

}
