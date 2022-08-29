package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.AddressEntity;
import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Entity.CartDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
@Repository
public interface CartDetailRepository  extends JpaRepository<CartDetailEntity,Long> {


    //public Set<BookEntity> getAllByBookAndIsActived();

    @Transactional
    @Modifying
    @Query("update CartDetailEntity details set details.quantity = :updateQuantity where details.id = :id")
    void setQuantityForSameBook(@Param("updateQuantity") Integer updateQuantity, @Param("id") Long id);

    public List<CartDetailEntity> findByIsActivedIsTrueAndCart_Id(Long cart_id);

    public CartDetailEntity findByCart_IdAndBook_Id(Long cartId, Long bookId);
    public CartDetailEntity findByBook_IdAndCart_IdAndIsActivedIsTrue(Long bookId, Long cartId);


}
