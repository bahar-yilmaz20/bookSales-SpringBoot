package com.ReadingIsGood.readingisgood.Entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name="Discount")
public class DiscountEntity extends CreatedAndUpdatedDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Double discount_percent;
    private Boolean actived;

}
