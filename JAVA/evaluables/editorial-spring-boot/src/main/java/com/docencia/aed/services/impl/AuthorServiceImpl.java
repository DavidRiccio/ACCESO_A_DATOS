package com.docencia.aed.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.models.Author;
import com.docencia.aed.repository.AuthorRepository;
import com.docencia.aed.services.interfaces.IAuthorService;
@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;
    
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    
    @Override
    public Author findById(Long authorId) {
       return authorRepository.findById(authorId).orElse(null);
    }

    @Override
    public Author create(Author author) {
       return authorRepository.save(author);
    }

    @Override
    public boolean delete(Author author) {
        authorRepository.delete(author);
        return true;
    }

    @Override
    public boolean deleteById(Long authorId) {
      authorRepository.deleteById(authorId);
      return true;
    }
    
}
