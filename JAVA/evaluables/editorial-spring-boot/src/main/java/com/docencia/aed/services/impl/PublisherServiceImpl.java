package com.docencia.aed.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.models.Publisher;
import com.docencia.aed.repository.PublisherRepository;
import com.docencia.aed.services.interfaces.IPublisherService;
@Service
public class PublisherServiceImpl implements IPublisherService {

    @Autowired
    PublisherRepository publisherRepository;
    
    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher save(Publisher publisher) {
      return publisherRepository.save(publisher);
    }
    
}
