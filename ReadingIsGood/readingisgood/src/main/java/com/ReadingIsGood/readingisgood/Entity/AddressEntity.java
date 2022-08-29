package com.ReadingIsGood.readingisgood.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Address")
public class AddressEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;
    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String district;
    @NotNull
    private String details;
    private String post_code;
    @NotNull
    private Date created_at;
    private Date updated_at;

}
