package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Entity.OrderDetailEntity;
import com.ReadingIsGood.readingisgood.Entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IOrderDetailService {

    public OrderDetailEntity getOrderDetail(Long id);
    public void savingOrderDetails(BookEntity book, OrderEntity savedOrder);

    public int ListOfBookSaledMonthly(Date dateforMonth);


}
