package com.docencia.rest.mappers;

import com.docencia.rest.domain.Producto;
import com.docencia.rest.modelo.DetalleProductoDocument;
import com.docencia.rest.modelo.ProductoEntity;

public class MapperProducto implements ProductoMapper{

    private DetalleProductoMapper detalleProductoMapper;

    public MapperProducto(DetalleProductoMapper detalleProductoMapper){
        this.detalleProductoMapper = detalleProductoMapper;
    }

    @Override
    public ProductoEntity toEntity(Producto source) {
       ProductoEntity producto = new ProductoEntity(source.getNombre(), source.getPrecio(), source.getStock());

       return producto;
    }

    @Override
    public Producto toDomain(ProductoEntity source) {
        Producto producto = new Producto(source.getId(), source.getNombre(), source.getPrecio(), source.getStock(), null);
        return producto;
    }

    @Override
    public Producto toDomain(ProductoEntity entity, DetalleProductoDocument detalle) {
         Producto producto = new Producto(entity.getId(), entity.getNombre(), entity.getPrecio(), entity.getStock(), detalleProductoMapper.toDomain(detalle));
         return producto;
    }
    
}
