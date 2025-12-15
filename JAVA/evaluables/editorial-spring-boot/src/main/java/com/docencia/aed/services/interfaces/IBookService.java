package com.docencia.aed.services.interfaces;

import java.util.List;

import com.docencia.aed.models.Book;

public interface IBookService {
    /**
     * Lista todos los libros
     * 
     * @return
     */
    List<Book> findAll();

    /**
     * Busca un libro por id
     * 
     * @param bookId id del libro
     * @return El libro si existe o null
     */
    Book findById(Long bookId);

    /**
     * Crea un libro asociado
     * 
     * @param book     libro a crear
     * @param authorId id del autor
     * @return el libro creado
     */
    Book createByAuthorId(Book book, Long authorId);


    /**
     * Busca los libros por id del autor
     * @param id ide del autor
     * @return el libro
     */
    List<Book> findByAuthorId(Long id);
    
}
