package com.ReadingIsGood.readingisgood.DTO;

import com.ReadingIsGood.readingisgood.Entity.PaymentInformat─▒onEntity;
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
public class OrderDto {
    public Long customer_id;
    public Boolean isApprovedTerms;
    public PaymentInformat─▒onEntity paymentInformat─▒on;

}
