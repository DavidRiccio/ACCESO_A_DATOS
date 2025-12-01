package com.docencia.rest.mappers;

import org.mapstruct.Mapper;

import com.docencia.rest.domain.DetalleProducto;
import com.docencia.rest.modelo.DetalleProductoDocument;

@Mapper(componentModel = "spring", imports = DetalleProducto.class )
public interface DetalleProductoMapper {

    /**
     * Convierte un DetalleProducto a un DetalleProductoDocument
     * @param source Objeto DetalleProducto a convertir
     * @return Objeto DetalleProductoDocument convertido
     */
    DetalleProductoDocument toDocument(DetalleProducto source);

    /**
     * Convierte un DetalleProductoDocument a un DetalleProducto
     * @param source Objeto DetalleProductoDocument a convertir
     * @return Objeto DetalleProducto convertido
     */
    DetalleProducto toDomain(DetalleProductoDocument source);

}
