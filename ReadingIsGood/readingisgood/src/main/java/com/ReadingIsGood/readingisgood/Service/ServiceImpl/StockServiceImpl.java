package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.DTO.StockDto;
import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Entity.StockEntity;
import com.ReadingIsGood.readingisgood.Repository.BookRepository;
import com.ReadingIsGood.readingisgood.Repository.StockRepository;
import com.ReadingIsGood.readingisgood.Service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Filter;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements IStockService {
    @Autowired
    public StockRepository stockRepository;
    @Autowired
    public BookRepository bookRepository;


    @Override
    public StockEntity getStockWithBookId(Long id) {
        return stockRepository.getStockEntityByBook_id(id);
    }

    public String addStock(StockEntity stockEntity) {
        BookEntity book = bookRepository.getById(stockEntity.getBook().getId());
        if (book.equals(null))
            return null;
        stockEntity.setBook(book);
        stockEntity.setCreatedAt(Date.from(Instant.now()));
        stockRepository.save(stockEntity);
        return "ok";
    }


    @Override
    public StockDto outOfStockBooks() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        StockDto stockForStatistic = new StockDto();
        stockForStatistic.setStocks(stockRepository.findByCountLessThanEqual(0));
        stockForStatistic.setHowManySalesBooks(stockRepository.countByCountLessThanEqualAndUpdatedAtIsBetween(6,Date.from(Instant.now()), cal.getTime()));
        stockForStatistic.setBookNames((stockRepository.findByCountLessThanEqual(0)).stream().
                map(s->s.getBook()).collect(Collectors.toList()));
        return stockForStatistic;
    }

    @Override
    public int decreaseStockforOrder(Long id, int quantity) {
        return 0;
    }
}
