package com.example.relationstask.controller;

import com.example.relationstask.dto.BookRequest;
import com.example.relationstask.entity.Book;
import com.example.relationstask.exception.BookNotFoundException;
import com.example.relationstask.service.BookService;
import com.example.relationstask.util.Constants;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    BookService bookService;

    @PostMapping
    Book saveBookDetails(@RequestBody @Valid BookRequest bookRequest){
        logger.info("saving book details..");
        return bookService.createBook(bookRequest);
    }

    @GetMapping("{id}")
    Book getBookById(@PathVariable("id") int id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @GetMapping
    List<Book> getAllBooks(){
        logger.info("getting all book details from db");
        return bookService.getAllBooks();
    }

    @PutMapping("{id}")
    Constants updateBookById(@PathVariable("id") int id ,
                             @RequestBody @Valid BookRequest bookRequest) throws BookNotFoundException {
        logger.info("update books by Id");
        return bookService.updateBook(id,bookRequest);
    }

    @DeleteMapping("{id}")
    Constants deleteBook(@PathVariable("id") int id) throws BookNotFoundException {
        return bookService.deleteBook(id);
    }
}
