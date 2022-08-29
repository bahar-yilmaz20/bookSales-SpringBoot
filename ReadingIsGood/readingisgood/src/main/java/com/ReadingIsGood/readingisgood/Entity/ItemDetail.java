package com.ReadingIsGood.readingisgood.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class ItemDetail extends CreatedAndUpdatedDate{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name="book_id")
    private BookEntity book; //sadece book olacak liste değil..
    @NotNull
    private int quantity;
}
