package com.docencia.aed.services.interfaces;

import java.util.List;

import com.docencia.aed.models.Publisher;

public interface IPublisherService {
    /**
     * Lista todos los publisher
     * 
     * @return Lista con todos los publisher
     */
    List<Publisher> findAll();

    /**
     * Crea un nuevo publisher
     * 
     * @param publisher publisher a crear
     * @return El publisher que has creado
     */
    Publisher save(Publisher publisher);
}
