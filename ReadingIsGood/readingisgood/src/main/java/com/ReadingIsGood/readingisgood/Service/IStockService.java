package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.DTO.StockDto;
import com.ReadingIsGood.readingisgood.Entity.StockEntity;
import org.springframework.stereotype.Service;

@Service
public interface IStockService {

    public StockEntity getStockWithBookId(Long id);
    public String addStock(StockEntity stockEntity);
    public StockDto outOfStockBooks();
    public int decreaseStockforOrder(Long id, int quantity);
}
