package com.ReadingIsGood.readingisgood.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Stock")
public class StockEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name="book_id",nullable = false)
    private BookEntity book;
    private int count;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;


}
