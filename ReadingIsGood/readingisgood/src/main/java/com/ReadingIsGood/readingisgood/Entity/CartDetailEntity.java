package com.ReadingIsGood.readingisgood.Entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

@Getter
@Setter
@Data
@Entity
@Transactional
@Table(name = "CartDetails")
public class CartDetailEntity extends ItemDetail implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL) // fetch type default eager
    @JoinColumn(name="cart_id")
    private CartEntity cart;
    private Boolean isActived;


}
