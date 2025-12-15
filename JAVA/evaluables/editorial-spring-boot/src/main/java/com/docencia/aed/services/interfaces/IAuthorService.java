package com.docencia.aed.services.interfaces;

import java.util.List;

import com.docencia.aed.models.Author;

public interface IAuthorService {
    /**
     * Lista todos los autores
     * 
     * @return
     */
    List<Author> findAll();

    /**
     * Busca un autor por id
     * 
     * @param authorId id del autor
     * @return el autor y si no existe null
     */
    Author findById(Long authorId);

    /**
     * Guarda un autor
     * 
     * @param author autor que se quiere guardar
     * @return el autor
     */
    Author create(Author author);

    /**
     * Borra un autor
     * 
     * @param author autor que se quiere borrar
     * @return true si funciona
     */
    boolean delete(Author author);

    /**
     * Borra un autor por id
     * 
     * @param authorId id del autor
     * @return true si funciona
     */
    boolean deleteById(Long authorId);

}
