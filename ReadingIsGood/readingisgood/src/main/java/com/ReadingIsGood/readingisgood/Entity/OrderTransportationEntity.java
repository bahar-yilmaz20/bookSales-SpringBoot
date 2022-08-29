package com.ReadingIsGood.readingisgood.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "OrderTransportation")
public class OrderTransportationEntity extends CreatedAndUpdatedDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean is_confirmed;
    private Boolean is_shipped;
    private Boolean is_delivered;
    private Date date_of_confirmed;
    private Date date_of_shipped;
    private Date date_of_delivered;

}
