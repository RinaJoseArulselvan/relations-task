package com.example.relationstask.service.impl;

import com.example.relationstask.dto.PublisherRequest;
import com.example.relationstask.entity.Book;
import com.example.relationstask.entity.Publisher;
import com.example.relationstask.exception.PublisherNotFoundException;
import com.example.relationstask.repository.BookRepository;
import com.example.relationstask.repository.PublisherRepository;
import com.example.relationstask.service.BookService;
import com.example.relationstask.service.PublisherService;
import com.example.relationstask.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public Publisher createPublisher(PublisherRequest publisherRequest) {
        List<Book> bookList = bookRepository.findAllById(publisherRequest.getBookList());
        Publisher publisher = Publisher.build(
                0,
                publisherRequest.getName(),
                publisherRequest.getAddress(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                bookList
    );
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(int id) throws PublisherNotFoundException {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        if(publisher == null){
            throw new PublisherNotFoundException(Constants.BOOK_NOT_FOUND.name());
        }else {
            return publisher;
        }
    }

    @Override
    public Constants updatePublisher(int id,PublisherRequest publisherRequest) throws PublisherNotFoundException {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        if(publisher != null){
            publisher.setName(publisherRequest.getName());
            publisher.setAddress(publisherRequest.getAddress());
            publisher.setUpdated_date(LocalDateTime.now());
            publisherRepository.save(publisher);
            return Constants.UPDATED;
        }else {
            throw new PublisherNotFoundException("publisher not found");
        }
    }

    @Override
    public Constants deletePublisher(int id) throws PublisherNotFoundException {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        if(publisher != null){
            publisherRepository.deleteById(id);
            return Constants.DELETED;
        }else {
            throw new PublisherNotFoundException("publisher not found");
        }
    }

    @Override
    public List<Book> getBooksByPublisher(int id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        if(publisher != null){
            return publisher.getBookList();
        }else {
            return Collections.emptyList();
        }

    }
}
