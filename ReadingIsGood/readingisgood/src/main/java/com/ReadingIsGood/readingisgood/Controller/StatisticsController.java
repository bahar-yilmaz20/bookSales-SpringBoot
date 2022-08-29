package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.DTO.CustomerDto;
import com.ReadingIsGood.readingisgood.DTO.OrderDto;
import com.ReadingIsGood.readingisgood.DTO.StockDto;
import com.ReadingIsGood.readingisgood.Service.IBookService;
import com.ReadingIsGood.readingisgood.Service.ICustomerService;
import com.ReadingIsGood.readingisgood.Service.IOrderDetailService;
import com.ReadingIsGood.readingisgood.Service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/statistics")
@ComponentScan
@EnableAutoConfiguration
class StatisticsController {


    @Autowired
    private IBookService bookService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IStockService stockService;
    @Autowired
    private IOrderDetailService orderDetailService;

    @RequestMapping(value = "/monthly/book", method = RequestMethod.GET, produces = "application/json")
    public int monthlyStatisticsBook() {
        return orderDetailService.ListOfBookSaledMonthly(Date.from(Instant.now()));
    }

    @RequestMapping(value = "/monthly/customer", method = RequestMethod.GET, produces = "application/json")
    public CustomerDto monthlyStatisticsCustomer() {
        return customerService.getCustomerCreatedAtMonthly(Date.from(Instant.now()));
    }

    @RequestMapping(value = "/books/outOfStock", method = RequestMethod.GET, produces = "application/json")
    public StockDto booksOutOfStock() {
        return stockService.outOfStockBooks();
    }

}
