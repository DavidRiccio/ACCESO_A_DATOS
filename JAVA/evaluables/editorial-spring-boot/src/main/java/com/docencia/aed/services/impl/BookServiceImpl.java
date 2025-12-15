package com.docencia.aed.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.models.Author;
import com.docencia.aed.models.Book;
import com.docencia.aed.repository.AuthorRepository;
import com.docencia.aed.repository.BookRepository;
import com.docencia.aed.services.interfaces.IBookService;
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired 
    AuthorRepository authorRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public Book createByAuthorId(Book book, Long authorId) {
        Book newBook = new Book();
        Author author = authorRepository.findById(authorId).orElse(null);
        newBook.setAuthor(author);
        newBook.setPublicationYear(book.getPublicationYear());
        newBook.setTitle(book.getTitle());
        return bookRepository.save(newBook);
    }

    @Override
    public List<Book> findByAuthorId(Long id) {
       return bookRepository.findByAuthorId(id);
    }


    
}
