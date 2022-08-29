package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository  extends JpaRepository<DiscountEntity,Long> {
}
