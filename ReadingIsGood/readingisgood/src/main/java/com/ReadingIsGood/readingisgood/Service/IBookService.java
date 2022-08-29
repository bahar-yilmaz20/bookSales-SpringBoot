package com.ReadingIsGood.readingisgood.Service;

import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {


    List<BookEntity> getAllBooks();

    BookEntity getBook(Long id);

    BookEntity addBook(BookEntity book);


}
