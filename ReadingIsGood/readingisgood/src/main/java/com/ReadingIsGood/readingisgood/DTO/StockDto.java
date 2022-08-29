package com.ReadingIsGood.readingisgood.DTO;

import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Entity.StockEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class StockDto {
    public List<StockEntity> stocks;
    public int howManySalesBooks;
    public List<BookEntity> bookNames;

}
