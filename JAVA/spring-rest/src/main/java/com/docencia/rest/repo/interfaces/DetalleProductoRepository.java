package com.docencia.rest.repo.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.docencia.rest.model.DetalleProductoDocument;

public interface DetalleProductoRepository extends MongoRepository<DetalleProductoDocument, Integer> {
        Optional<DetalleProductoDocument> findProductoById(int productoId);


        boolean deleteProductoById(int productoId);
}
