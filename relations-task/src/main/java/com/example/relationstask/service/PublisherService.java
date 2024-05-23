package com.example.relationstask.service;

import com.example.relationstask.dto.PublisherRequest;
import com.example.relationstask.entity.Book;
import com.example.relationstask.entity.Publisher;
import com.example.relationstask.exception.PublisherNotFoundException;
import com.example.relationstask.util.Constants;

import java.util.List;
import java.util.Set;

public interface PublisherService {
    Publisher createPublisher(PublisherRequest publisherRequest);
    List<Publisher> getAllPublishers();
    Publisher getPublisherById(int id) throws PublisherNotFoundException;
    Constants updatePublisher(int id,PublisherRequest publisherRequest) throws PublisherNotFoundException;
    Constants deletePublisher(int id) throws PublisherNotFoundException;
    List<Book> getBooksByPublisher(int id);
}
