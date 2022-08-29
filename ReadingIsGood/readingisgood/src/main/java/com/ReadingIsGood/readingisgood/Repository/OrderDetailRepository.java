package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long>{
    public OrderDetailEntity findByOrder(Long id);
    public List<OrderDetailEntity> findByCreatedAtBetween(Date lasMonth,Date dateOfCreation);

}
