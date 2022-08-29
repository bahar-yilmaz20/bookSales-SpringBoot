package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.DTO.CartDto;
import com.ReadingIsGood.readingisgood.Entity.CartEntity;
import org.springframework.stereotype.Service;

@Service
public interface ICartService {


     String getCartWithCustomerId(CartDto cartDto) throws Exception;

     String addToCart(CartDto cartDto);

     CartEntity getCartExist(Long id);

      Double deleteFromCartDetail(Long customerId, Long bookId);
}
