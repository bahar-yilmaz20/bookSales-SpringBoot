package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.Entity.OrderDetailEntity;
import com.ReadingIsGood.readingisgood.Service.IOrderDetailService;
import net.bytebuddy.utility.JavaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

@RestController
@RequestMapping("v1/api/orderDetails")
@ComponentScan
@EnableAutoConfiguration
public class OrderDetailController {
    @Autowired
    private IOrderDetailService orderDetailService;

    @RequestMapping(value = "/getOrderDetails/{id}" ,method= RequestMethod.GET,produces = "application/json")
    private OrderDetailEntity getOrderDetails(@PathVariable Long id) {
        return orderDetailService.getOrderDetail(id);
    }




}
