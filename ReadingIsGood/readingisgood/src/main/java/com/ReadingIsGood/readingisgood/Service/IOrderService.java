package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.DTO.OrderDto;
import com.ReadingIsGood.readingisgood.Entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {
    public List<OrderEntity> getOrderByCustomerId(Long id);
    public OrderEntity makeOrder(OrderDto order);

}
