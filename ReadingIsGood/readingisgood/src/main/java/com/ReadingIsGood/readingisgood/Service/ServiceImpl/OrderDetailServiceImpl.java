package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.DTO.OrderDto;
import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Entity.OrderDetailEntity;
import com.ReadingIsGood.readingisgood.Entity.OrderEntity;
import com.ReadingIsGood.readingisgood.Repository.OrderDetailRepository;
import com.ReadingIsGood.readingisgood.Service.IOrderDetailService;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetailEntity getOrderDetail(Long id) {
        return orderDetailRepository.findByOrder(id);
    }

    @Transactional(value = Transactional.TxType.MANDATORY)
    @Override
    public void savingOrderDetails(BookEntity book, OrderEntity savedOrderEntity) {
        OrderDetailEntity savingOrderDetails = new OrderDetailEntity();
        savingOrderDetails.setBook(book);
        //savingOrderDetails.setOrder(savedOrderEntity);
        savingOrderDetails.setCreatedAt(Date.from(Instant.now()));
        orderDetailRepository.save(savingOrderDetails);
    }

    @Override
    public int ListOfBookSaledMonthly(Date dateforMonth) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        List<OrderDetailEntity> orderDetailEntitiesforMontlyBook =
                orderDetailRepository.findByCreatedAtBetween(cal.getTime(),dateforMonth);

        return orderDetailEntitiesforMontlyBook.size();
    }


}
