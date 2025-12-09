package com.docencia.rest.repository.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.docencia.rest.modelo.DetalleProductoDocument;

@Repository
public interface DetalleProductoRepository extends MongoRepository<DetalleProductoDocument, Integer> {
    /**
     * Busca un producto a traves de su id
     * @param productoId id del producto que quieres buscar
     * @return el producto que buscaste
     */    
    Optional<DetalleProductoDocument> findByProductoId(int productoId);

    /**
     * Borra un producto a traves de su id
     * @param productoId id del producto que quieres borrar
     * @return true si lo borraste
     */
    boolean deleteByProductoId(int productoId);
}
