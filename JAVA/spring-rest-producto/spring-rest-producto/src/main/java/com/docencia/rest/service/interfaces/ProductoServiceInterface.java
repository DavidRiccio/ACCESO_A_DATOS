package com.docencia.rest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.domain.Producto;

public interface ProductoServiceInterface {
    /**
     * Busca un producto en la base de datos a traves de si mismo
     * @param producto producto que quieres buscar
     * @return el producto que buscaste
     */
    Optional<Producto> find(Producto producto);

    /**
     * Busca un producto a traves de la id
     * @param id id del producto que quieres buscar
     * @return el producto que buscaste 
     */
    Optional<Producto> findById(int id);

    /**
     * Lista todos los productos de la base de datos
     * @return lista de productos
     */
    List<Producto> findAll();

    /**
     * Guarda un producto en la base de datos
     * @param producto producto que quieres guardar
     * @return el producto que guardaste
     */
    Producto save(Producto producto);
    /**
     * Borra un producto de la base de datos
     * @param producto producto que quieres borrar
     * @return true si lo borraste
     */
    boolean delete(Producto producto);
    
    /**
     * Borra un producto de la base de datos a traves de su id
     * @param id id del producto que quieres borrar
     * @return true si lo borraste 
     */
    boolean deleteById(int id);

}
