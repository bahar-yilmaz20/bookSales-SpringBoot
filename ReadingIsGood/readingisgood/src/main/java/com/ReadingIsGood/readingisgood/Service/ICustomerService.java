package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.DTO.CustomerDto;
import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ICustomerService {
    List<CustomerEntity> getAllCustomers();

    CustomerEntity getCustomer(Long id);

    CustomerEntity addCustomer(CustomerEntity customer);

    public CustomerDto getCustomerCreatedAtMonthly(Date dateForNow);

}
