package com.ReadingIsGood.readingisgood.Repository;

import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository <BookEntity , Long > {

    public List<BookEntity> getAllBy() ;

    @Override
    public BookEntity getById(Long id);

}
