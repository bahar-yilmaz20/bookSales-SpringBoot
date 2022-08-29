package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.DTO.OrderDto;
import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import com.ReadingIsGood.readingisgood.Entity.OrderDetailEntity;
import com.ReadingIsGood.readingisgood.Entity.OrderEntity;
import com.ReadingIsGood.readingisgood.Repository.BookRepository;
import com.ReadingIsGood.readingisgood.Repository.CustomerRepository;
import com.ReadingIsGood.readingisgood.Repository.OrderDetailRepository;
import com.ReadingIsGood.readingisgood.Repository.OrderRepository;
import com.ReadingIsGood.readingisgood.Service.IBookService;
import com.ReadingIsGood.readingisgood.Service.ICustomerService;
import com.ReadingIsGood.readingisgood.Service.IOrderDetailService;
import com.ReadingIsGood.readingisgood.Service.IOrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.time.Instant;
import java.util.*;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderDetailService orderDetailService;
    @Override
    public List<OrderEntity> getOrderByCustomerId(Long id) {
        return orderRepository.getOrderEntitiesByCustomer_id(id);
    }

    @Transactional
    @Override
    public OrderEntity makeOrder(OrderDto order){
       CustomerEntity customer=customerService.getCustomer(order.customer_id);
       OrderEntity savingOrder=new OrderEntity();
       savingOrder.setCustomer(customer);
       //savingOrder.setPrice(order.getPrice());
       //savingOrder.setQuantity(order.getQuantity());
       OrderEntity savedOrder=orderRepository.save(savingOrder);

       List<BookEntity> savingBookEntity=new ArrayList<>();
       //order.book_id.forEach(s-> savingBookEntity.add(bookService.getBook(s)));
       savingBookEntity.forEach(p->orderDetailService.savingOrderDetails(p,savingOrder));
       return savedOrder;
    }


}
