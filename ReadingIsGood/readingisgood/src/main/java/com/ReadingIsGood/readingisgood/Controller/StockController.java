package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.Entity.StockEntity;
import com.ReadingIsGood.readingisgood.Service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping("v1/api/stock")
@ComponentScan
@EnableAutoConfiguration
public class StockController {
    @Autowired
    public IStockService stockService;

    @RequestMapping(value = "/getStockWithBookid/{id}",method = RequestMethod.GET,produces = "application/json")
    public StockEntity getStockwithBook(@PathVariable Long id){
        return stockService.getStockWithBookId(id);
    }

    @RequestMapping(value = "/addStock",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public String addStock(@RequestBody StockEntity stockEntity){
        stockService.addStock(stockEntity);
        return "ok";
    }
}
