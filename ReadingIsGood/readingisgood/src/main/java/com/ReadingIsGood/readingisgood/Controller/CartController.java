package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.DTO.CartDto;
import com.ReadingIsGood.readingisgood.Entity.CartEntity;
import com.ReadingIsGood.readingisgood.Service.ICartService;
import com.ReadingIsGood.readingisgood.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/cart")
@ComponentScan
@EnableAutoConfiguration
public class CartController {

    @Autowired
    private ICartService cartService;

    @RequestMapping(value = "/addToCart",method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
    public String addToCartAndDetails(@RequestBody CartDto cartDto){
        return cartService.addToCart(cartDto);
    }
    @RequestMapping(value="deleteFromCart/{customerId}/{bookId}", method=RequestMethod.GET,produces = "application/json",consumes = "application/json")
    public Double deleteFromCartAndCartDetails(@PathVariable Long customerId, @PathVariable Long bookId){
        return cartService.deleteFromCartDetail(customerId,bookId);
    }


}
