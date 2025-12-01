package com.docencia.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.docencia.rest.domain.Producto;
import com.docencia.rest.modelo.DetalleProductoDocument;
import com.docencia.rest.modelo.ProductoEntity;

@Mapper(componentModel = "spring", uses = { DetalleProductoMapper.class })
public interface ProductoMapper {

    /**
     * Convierte un Producto a un ProductoEntity
     * @param source Objeto Producto a convertir
     * @return Objeto ProductoEntity convertido
     */
    ProductoEntity toEntity(Producto source);

    /**
     * Convierte un ProductoEntity a un Producto
     * @param source Objeto ProductoEntity a convertir
     * @return Objeto Producto convertido
     */
    Producto toDomain(ProductoEntity source);
    
    /**
     * Convierte un ProductoEntity a un Producto con Detalle
     * @param entity Objeto ProductoEntity a convertir
     * @param detalle Objeto DetalleProductoDocument a convertir
     * @return Objeto Producto convertido
     */
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "detalleProducto", source = "detalle")
    Producto toDomain(ProductoEntity entity, DetalleProductoDocument detalle);

} 