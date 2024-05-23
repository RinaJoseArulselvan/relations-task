package com.example.relationstask.service;

import com.example.relationstask.dto.BookRequest;
import com.example.relationstask.entity.Book;
import com.example.relationstask.exception.BookNotFoundException;
import com.example.relationstask.util.Constants;

import java.util.List;

public interface BookService {
    Book createBook(BookRequest bookRequest);
    List<Book> getAllBooks();
    Book getBookById(int id) throws BookNotFoundException;
    Constants updateBook(int id,BookRequest bookRequest) throws BookNotFoundException;
    Constants deleteBook(int id) throws BookNotFoundException;
}
