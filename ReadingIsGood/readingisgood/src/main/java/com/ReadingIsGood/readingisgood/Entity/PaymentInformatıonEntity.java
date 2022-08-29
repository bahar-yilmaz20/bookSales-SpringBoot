package com.ReadingIsGood.readingisgood.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "Payment")
public class PaymentInformatıonEntity extends CreatedAndUpdatedDate implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;
    private String cartNumber;
    private String cartOwnerName;
    private String dateOfCart;
    private String CVV;

}
