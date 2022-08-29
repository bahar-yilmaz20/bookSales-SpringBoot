package com.ReadingIsGood.readingisgood.Service.ServiceImpl;

import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Repository.BookRepository;
import com.ReadingIsGood.readingisgood.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.getAllBy();
    }

    @Override
    public BookEntity getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public BookEntity addBook(BookEntity book) {
        book.setCreatedAt();
         return bookRepository.save(book);
    }
}
