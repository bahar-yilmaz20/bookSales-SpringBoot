package com.ReadingIsGood.readingisgood.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Book")
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity extends CreatedAndUpdatedDate implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String writer;
    @NotNull
    private Double price;
    @NotNull
    private String publisher;
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull
    private Date date_of_publish;
    @NotNull
    private int which_edition;

    @ManyToMany
    @JoinColumn(name="category_id")
    private List<CategoryEntity> category_id;
    @OneToOne
    @JoinColumn(name="discount_id")
    private DiscountEntity discount;



}
