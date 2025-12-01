package com.docencia.rest.mappers;


import org.mapstruct.Mapper;

import com.docencia.rest.domain.DetalleProducto;
import com.docencia.rest.model.DetalleProductoDocument;


@Mapper(componentModel = "spring",uses = { DetalleProducto.class })
public interface DetalleProductoMapper {

    // Dominio -> Mongo
    DetalleProductoDocument toDocument(DetalleProducto source);

    // Mongo -> Dominio
    DetalleProducto toDocument(DetalleProductoDocument source);
}
