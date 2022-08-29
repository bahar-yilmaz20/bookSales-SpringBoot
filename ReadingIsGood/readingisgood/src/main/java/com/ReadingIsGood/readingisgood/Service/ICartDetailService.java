package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.DTO.CartDto;
import com.ReadingIsGood.readingisgood.Entity.CartDetailEntity;
import org.springframework.stereotype.Service;

@Service
public interface ICartDetailService {
    void save(CartDetailEntity savedCartDetail);

    Double calculateBookPriceInCart(Long cartId);

    String addToCartDetail(CartDto cartDto) throws Exception;

    Double deleteFromCartAndCartDetails(Long cartId, Long bookId);

}
