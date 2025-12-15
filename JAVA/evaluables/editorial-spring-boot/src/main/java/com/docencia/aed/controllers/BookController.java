package com.docencia.aed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.aed.models.Book;
import com.docencia.aed.services.impl.BookServiceImpl;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "Operaciones sobre libros")
public class BookController {
    private BookServiceImpl bookServiceImpl;

    @Autowired
    public void setBookServiceImpl(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @Operation(summary = "Get all books")
    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookServiceImpl.findAll();
    }

    @Operation(summary = "Get book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long authorId) {
        Book book = bookServiceImpl.findById(authorId);
        return ResponseEntity.ok().body(book);
    }

    @Operation(summary = "Insert book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/")
    public Book createByAuthor(Long author_id, Book book) {
        return bookServiceImpl.createByAuthorId(book, author_id);
    }

}
