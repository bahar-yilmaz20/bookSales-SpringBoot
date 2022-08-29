package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Entity.CustomerEntity;
import com.ReadingIsGood.readingisgood.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/api/customers")
@ComponentScan
@EnableAutoConfiguration
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/getAllCustomers",method = RequestMethod.GET, produces = "application/json")
    public List<CustomerEntity> getAllCustomer()  {
        if (customerService.getAllCustomers().isEmpty())
            return new ArrayList<>();
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, produces = "application/json")
    public CustomerEntity getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }


    @RequestMapping(
            value = "/addCustomer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customer) {

        customerService.addCustomer(customer);
        return new ResponseEntity<CustomerEntity>( HttpStatus.OK);
    }
}
