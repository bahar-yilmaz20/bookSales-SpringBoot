package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.DTO.CustomerDto;
import com.ReadingIsGood.readingisgood.DTO.OrderDto;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import com.ReadingIsGood.readingisgood.Repository.AddressRepository;
import com.ReadingIsGood.readingisgood.Repository.CustomerRepository;
import com.ReadingIsGood.readingisgood.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.getAllBy();
    }

    @Override
    public CustomerEntity getCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public CustomerEntity addCustomer(CustomerEntity customer) {
        customer.setCreatedAt(Date.from(Instant.now()));
        return customerRepository.save(customer);
    }

    @Override
    public CustomerDto getCustomerCreatedAtMonthly(Date dateForNow) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        CustomerDto customerDtoForStatistic = new CustomerDto();
        customerDtoForStatistic.setCountOfCustomer(customerRepository.findByCreatedAtBetween(cal.getTime(), dateForNow).size());
        customerDtoForStatistic.setCustomerEntities(customerRepository.findByCreatedAtBetween(cal.getTime(), dateForNow));
        return customerDtoForStatistic;
    }
}
