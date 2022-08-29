package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.DTO.OrderDto;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import com.ReadingIsGood.readingisgood.Entity.OrderEntity;
import com.ReadingIsGood.readingisgood.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/orders")
@ComponentScan
@EnableAutoConfiguration
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/getOrderById/{id}", method = RequestMethod.GET,produces = "application/json")
    public List<OrderEntity> getOrderByCustomerId(@PathVariable Long id){
       return orderService.getOrderByCustomerId(id);
    }
    @RequestMapping(value = "/makeOrder", method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
    public OrderEntity makeOrder(@RequestBody OrderDto order){
        return orderService.makeOrder(order);
    }

}
