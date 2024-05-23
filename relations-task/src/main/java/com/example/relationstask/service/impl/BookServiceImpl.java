package com.example.relationstask.service.impl;

import com.example.relationstask.RelationsTaskApplication;
import com.example.relationstask.dto.BookRequest;
import com.example.relationstask.entity.Book;
import com.example.relationstask.entity.Publisher;
import com.example.relationstask.exception.BookNotFoundException;
import com.example.relationstask.repository.BookRepository;
import com.example.relationstask.repository.PublisherRepository;
import com.example.relationstask.service.BookService;
import com.example.relationstask.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PublisherRepository publisherRepository;

    BookService bookService;
    @Override
    public Book createBook(BookRequest bookRequest) {
        Publisher publisher = publisherRepository.findById(bookRequest.getPublisher_id()).orElse(null);
        Book book = Book.build(
                0,
                bookRequest.getTitle(),
                bookRequest.getDescription(),
                bookRequest.getCategory(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                publisher
        );
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null){
            logger.info("Book not found");
            throw new BookNotFoundException("Book not found");
        }else {
            return book;
        }
    }

    @Override
    public Constants updateBook(int id, BookRequest bookRequest) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null){
            book.setTitle(bookRequest.getTitle());
            book.setDescription(bookRequest.getDescription());
            book.setCategory(bookRequest.getCategory());
            book.setUpdated_date(LocalDateTime.now());
            bookRepository.save(book);
            return Constants.UPDATED;
        }else {
            throw new BookNotFoundException(Constants.BOOK_NOT_FOUND.name());
        }
    }

    @Override
    public Constants deleteBook(int id) throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null){
            bookRepository.deleteById(id);
            return Constants.DELETED;
        } else {
            throw new BookNotFoundException(Constants.BOOK_NOT_FOUND.name());
        }
    }
}
