package com.example.relationstask.controller;

import com.example.relationstask.dto.PublisherRequest;
import com.example.relationstask.entity.Book;
import com.example.relationstask.entity.Publisher;
import com.example.relationstask.exception.PublisherNotFoundException;
import com.example.relationstask.service.PublisherService;
import com.example.relationstask.util.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    PublisherService publisherService;
    @PostMapping
    Publisher createPublisher(@RequestBody @Valid PublisherRequest publisherRequest){
        return publisherService.createPublisher(publisherRequest);
    }

    @GetMapping("{id}")
    Publisher getPublisher(@PathVariable("id") int id) throws PublisherNotFoundException {
        return publisherService.getPublisherById(id);
    }

    @GetMapping("book/{id}")
    List<Book> getBooksByPublisher(@PathVariable("id") int id){
        return publisherService.getBooksByPublisher(id);
    }

    @GetMapping
    List<Publisher> getAllPublishers(){
        return publisherService.getAllPublishers();
    }

    @PutMapping("{id}")
    Constants updatePublisher(@PathVariable("id") int id,
                              @RequestBody @Valid PublisherRequest publisherRequest)
            throws PublisherNotFoundException {
        return publisherService.updatePublisher(id,publisherRequest);
    }

    @DeleteMapping("{id}")
    Constants deletePublisher(@PathVariable("id") int id) throws PublisherNotFoundException {
        return publisherService.deletePublisher(id);
    }

}
