package com.docencia.aed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.aed.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    /**
     * Busca por id del autor
     * @param authorId autor id
     * @return Lista de libros del autor
     */
    List<Book> findByAuthorId(Long authorId);
}
