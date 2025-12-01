package com.docencia.rest.mappers;

import com.docencia.rest.domain.DetalleProducto;
import com.docencia.rest.modelo.DetalleProductoDocument;

public class MapperDetalleProducto implements DetalleProductoMapper{

    @Override
    public DetalleProductoDocument toDocument(DetalleProducto source) {
       DetalleProductoDocument detalleProducto = new DetalleProductoDocument(source.getId(), source.getProductoId(), source.getDescripcionLarga(), source.getEspecificacionesTecnicas(), source.getTags());
       return detalleProducto;
    }

    @Override
    public DetalleProducto toDomain(DetalleProductoDocument source) {
       DetalleProducto detalleProducto = new DetalleProducto(source.getId(), source.getProductoId(), source.getDescripcionLarga(), source.getEspecificacionesTecnicas(), source.getTags());
       return detalleProducto;
    }
    
}
