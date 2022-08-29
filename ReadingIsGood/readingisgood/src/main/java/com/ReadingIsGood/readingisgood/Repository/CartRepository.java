package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Entity.CartEntity;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
public interface CartRepository  extends JpaRepository<CartEntity,Long> {
    CartEntity getByCustomer(CustomerEntity customer);

    CartEntity findByCustomer_Id(Long Id);

    @Transactional
    @Modifying
    @Query("update CartEntity cartTotal set cartTotal.total = :totalPrice where cartTotal.id = :id")
    void setTotalPriceInCart(@Param("totalPrice") Double totalPrice, @Param("id") Long id);

}
