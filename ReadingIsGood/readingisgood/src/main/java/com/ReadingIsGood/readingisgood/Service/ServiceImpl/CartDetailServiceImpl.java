package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.DTO.CartDto;
import com.ReadingIsGood.readingisgood.Entity.CartDetailEntity;
import com.ReadingIsGood.readingisgood.Repository.CartDetailRepository;
import com.ReadingIsGood.readingisgood.Service.IBookService;
import com.ReadingIsGood.readingisgood.Service.ICartDetailService;
import com.ReadingIsGood.readingisgood.Service.ICartService;
import com.ReadingIsGood.readingisgood.Service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CartDetailServiceImpl implements ICartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private IBookService bookService;

    private ICartService cartService;

    @Autowired
    public CartDetailServiceImpl(@Lazy ICartService cartService) {
        this.cartService = cartService;
    }

    public Double calculateBookPriceInCart(Long cartId) {

        List<Double> pricesesBookInTheCart = new ArrayList<>();
        cartDetailRepository.findByIsActivedIsTrueAndCart_Id(cartId).forEach(x -> pricesesBookInTheCart.add(x.getBook().getPrice()*x.getQuantity()));
        //discount eklenmeli..
        //stockta olmayanlar düşmeli..
        Double total = pricesesBookInTheCart.stream().collect(Collectors.summingDouble(Double::doubleValue));
        return total;
    }

    @Override
    public String addToCartDetail(CartDto cartDto) throws Exception{
        //Add to cart details
        try{ //aynı isimde active bir ürün var mı, varsa quantity güncelle
            if (Objects.isNull(cartDetailRepository.findByBook_IdAndCart_IdAndIsActivedIsTrue(cartDto.book_id,cartDto.getCartId()))){
                CartDetailEntity savingCartDetail = new CartDetailEntity();
                savingCartDetail.setIsActived(true);
                savingCartDetail.setCreatedAt();
                savingCartDetail.setBook(bookService.getBook(cartDto.getBook_id()));
                savingCartDetail.setQuantity(cartDto.getQuantity());
                savingCartDetail.setCart(cartService.getCartExist(cartDto.getCartId()));
                save(savingCartDetail);
                return "Add to cart Successfully";
            }else {
                CartDetailEntity updateTheBookIsAlreadyExist=new CartDetailEntity();
                updateTheBookIsAlreadyExist=cartDetailRepository.findByBook_IdAndCart_IdAndIsActivedIsTrue(cartDto.book_id,cartDto.getCartId());
                //updateTheBookIsAlreadyExist.setQuantity(cartDetailRepository.findByBook_IdAndCart_IdAndIsActivedIsTrue(cartDto.book_id,cartDto.getCartId()).getQuantity()+1);
                cartDetailRepository.setQuantityForSameBook(updateTheBookIsAlreadyExist.getQuantity()+1,updateTheBookIsAlreadyExist.getId());
                return "Update the book quantity";
            }
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    public Double deleteFromCartAndCartDetails(Long cartId, Long bookId) {
        //ilk cart detailsden unactive et then total kısmı tekrar hesapla
        CartDetailEntity bookForUnactived=cartDetailRepository.findByBook_IdAndCart_IdAndIsActivedIsTrue(bookId,cartId);
        bookForUnactived.setIsActived(false);
        cartDetailRepository.save(bookForUnactived);
        return calculateBookPriceInCart(cartId);
    }


    @Override
    public void save(CartDetailEntity savingCartDetail) {
        cartDetailRepository.save(savingCartDetail);
    }


}
