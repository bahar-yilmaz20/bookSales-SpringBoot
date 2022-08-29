package com.ReadingIsGood.readingisgood.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Cart")
public class CartEntity extends Item implements Serializable {

}
