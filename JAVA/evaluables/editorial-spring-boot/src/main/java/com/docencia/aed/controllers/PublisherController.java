package com.docencia.aed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.aed.models.Publisher;
import com.docencia.aed.services.impl.PublisherServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/publishers")
@Tag(name = "Publisher", description = "Operaciones sobre publisher")
public class PublisherController {
    private PublisherServiceImpl publisherServiceImpl;

    @Autowired
    public void setPublisherServiceImpl(PublisherServiceImpl publisherServiceImpl) {
        this.publisherServiceImpl = publisherServiceImpl;
    }

    @Operation(summary = "Get all publishers")
    @GetMapping("/")
    public List<Publisher> getAllBooks() {
        return publisherServiceImpl.findAll();
    }

    @Operation(summary = "Create a publisher")
    @PostMapping("/")
    public Publisher createPublisher (Publisher publisher) {
        return publisherServiceImpl.save(publisher);
    }

}
