package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.DTO.CartDto;
import com.ReadingIsGood.readingisgood.Entity.CartEntity;
import com.ReadingIsGood.readingisgood.Repository.CartRepository;
import com.ReadingIsGood.readingisgood.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CartServiceImpl implements ICartService {

    private ICartDetailService cartDetailService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private IStockService stockService;
    @Autowired
    private IBookService bookService;

    @Autowired
    public CartServiceImpl(@Lazy ICartDetailService cartDetailService) {
        this.cartDetailService = cartDetailService;
    }

    @Override
    public String getCartWithCustomerId(CartDto cartDto) throws Exception {
        try { //stockta var mı control yap, bu admaın daha önce oluşmuş mu?
            if (stockService.getStockWithBookId(cartDto.getBook_id()).getCount() != 0) {
                if (Objects.isNull(cartRepository.findByCustomer_Id(cartDto.getCustomer_id()))) {
                    CartEntity createCart = new CartEntity();
                    createCart.setCustomer(customerService.getCustomer(cartDto.getCustomer_id()));
                    createCart.setCreatedAt();
                    createCart.setTotal(bookService.getBook(cartDto.book_id).getPrice());
                    cartRepository.save(createCart);
                    cartDto.setCartId(cartRepository.findByCustomer_Id(cartDto.customer_id).getId());
                    cartDetailService.addToCartDetail(cartDto);
                } else {
                    CartEntity cartIfExist = cartRepository.getByCustomer(customerService.getCustomer(cartDto.getCustomer_id()));
                    cartDto.setCartId(cartIfExist.getId());
                    cartIfExist.setTotal(cartDetailService.calculateBookPriceInCart(cartDto.getCartId()));
                    cartDetailService.addToCartDetail(cartDto);
                    cartRepository.save(cartIfExist);
                }
                return "Added to Cart";
            } else {
                return "This book is out of the stock!";
            }
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    @Override
    public String addToCart(CartDto cartDto) {
        try {
            return getCartWithCustomerId(cartDto);
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }

    }


    @Override
    public Double deleteFromCartDetail(Long customerId, Long bookId) {
        Long id = cartRepository.findByCustomer_Id(customerId).getId();
        Double totalPriceForUpdate=cartDetailService.deleteFromCartAndCartDetails(id, bookId);
        cartRepository.setTotalPriceInCart(totalPriceForUpdate,id);
        return totalPriceForUpdate;
    }

    @Override
    public CartEntity getCartExist(Long id) {

        return cartRepository.getById(id);
    }

    public void setCartDetailService(ICartDetailService cartDetailService) {
        this.cartDetailService = cartDetailService;
    }

}
