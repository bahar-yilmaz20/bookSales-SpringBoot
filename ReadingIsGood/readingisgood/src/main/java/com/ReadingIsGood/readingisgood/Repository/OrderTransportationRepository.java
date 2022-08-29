package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Entity.OrderTransportationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTransportationRepository  extends JpaRepository<OrderTransportationEntity,Long> {

}
