package com.ReadingIsGood.readingisgood.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "OrderDetails")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity extends ItemDetail implements Serializable {

    @ManyToOne
    @JoinColumn (name="order_id")
    private OrderEntity order;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @OneToOne
    @JoinColumn(name="ordertransportation_id")
    private OrderTransportationEntity transportation;

}
