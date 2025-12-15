package com.docencia.aed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.aed.models.Author;
import com.docencia.aed.models.Book;
import com.docencia.aed.services.impl.AuthorServiceImpl;
import com.docencia.aed.services.impl.BookServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/authors")
@Tag(name = "Autores", description = "Operaciones sobre autores")
public class AuthorController {

    private AuthorServiceImpl authorServiceImpl;
    private BookServiceImpl bookServiceImpl;

    @Autowired
    public void setBookServiceImpl(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @Autowired
    public void setAuthorServiceImpl(AuthorServiceImpl authorServiceImpl) {
        this.authorServiceImpl = authorServiceImpl;
    }

    @Operation(summary = "Get all authors")
    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return authorServiceImpl.findAll();
    }

    @Operation(summary = "Get author by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Long authorId) {
        Author author = authorServiceImpl.findById(authorId);
        return ResponseEntity.ok().body(author);
    }

    @Operation(summary = "Insert author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/")
    public Author createAuthor(Author author) {
        return authorServiceImpl.create(author);
    }

    @Operation(summary = "Get author by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable(value = "id") Long authorId) {
        List<Book> books = bookServiceImpl.findByAuthorId(authorId);
        return ResponseEntity.ok().body(books);
    }

}
