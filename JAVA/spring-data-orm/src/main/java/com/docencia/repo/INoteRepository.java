package com.docencia.repo;

import java.util.List;

import com.docencia.model.Note;

public interface INoteRepository {
    /**
     * Verifica si existe un objeto
     * 
     * @param id id del objeto
     * @return devuelve si el objeto existe
     */
    public boolean exists(String id);

    /**
     * Busca el objeto a traves de la id
     * 
     * @param id id del objeto a buscar
     * @return el objeto
     */
    public Note findById(String id);

    /**
     * Busca un objeto Note
     * 
     * @param note objeto note por el que buscar
     * @return el objeto note
     */
    public Note find(Note note);

    /**
     * 
     * @return lista de todos los objetos note
     */
    public List<Note> findAll();

    /**
     * Guarda un objeto note
     * 
     * @param note Objeto a guardar
     * @return
     */
    public Note save(Note note);

    /**
     * Borra un objeto note
     * 
     * @param id
     * @return
     */
    public boolean delete(String id);
}
