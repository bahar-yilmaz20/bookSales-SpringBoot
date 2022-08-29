package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    public List<CustomerEntity> getAllBy();

    public CustomerEntity getById(Long id);

    public List<CustomerEntity> findByCreatedAtBetween(Date lastMonth,Date now);

}
