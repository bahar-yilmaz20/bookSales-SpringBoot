package com.ReadingIsGood.readingisgood.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Making_Order")
public class OrderEntity extends Item implements Serializable {

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<OrderDetailEntity> orderDetails;
    @OneToOne
    @JoinColumn(name="address_id")
    private AddressEntity addressForOrder;
}
