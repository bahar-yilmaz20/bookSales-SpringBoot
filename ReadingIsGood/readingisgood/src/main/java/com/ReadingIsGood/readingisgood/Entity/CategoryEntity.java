package com.ReadingIsGood.readingisgood.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

import com.ReadingIsGood.readingisgood.Entity.CategoryType;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Category")
public class CategoryEntity extends CreatedAndUpdatedDate implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name="category_name")
    @NotNull
    private CategoryType name;
    private String description;
    @ManyToMany
    @JoinColumn(name="book_id")
    private List<BookEntity> book_id;


}
