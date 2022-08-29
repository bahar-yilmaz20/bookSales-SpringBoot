package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
    public StockEntity getStockEntityByBook_id(Long id);

    public List<StockEntity> findByCountLessThanEqual(int booksOfOutOfStock);

    public int countByCountLessThanEqualAndUpdatedAtIsBetween(int a,Date forThisMonth, Date lastMonth);
}
