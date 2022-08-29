package com.ReadingIsGood.readingisgood.Controller;

import com.ReadingIsGood.readingisgood.Entity.BookEntity;
import com.ReadingIsGood.readingisgood.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("v1/api/books")
@ComponentScan
@EnableAutoConfiguration
public class BookController {
    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/getAllBooks",method = RequestMethod.GET, produces = "application/json")
    public List<BookEntity> getAllBook()  {
        if (bookService.getAllBooks().isEmpty())
            return new ArrayList<>();
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET, produces = "application/json")
    public BookEntity getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }


    @RequestMapping(
            value = "/addBook", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<BookEntity> addBook(@RequestBody BookEntity book) {

        bookService.addBook(book);
        return new ResponseEntity<BookEntity>( HttpStatus.OK);
    }


}
