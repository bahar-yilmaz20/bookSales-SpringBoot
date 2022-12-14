package com.ReadingIsGood.readingisgood.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    public Long book_id;
    public Long customer_id;
    private Double price;
    public int quantity;
    public Long cartId;
}
