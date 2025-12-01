package com.docencia.rest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.domain.Producto;




/**
 * Interfaz de Productos 
 * @author DavidRiccio
 * @version 1.0.0 
 */

public interface ProductoServiceInterface {
    /**
     * Buscar un objeto Producto a traves de la id
     * 
     * @param id Id del producto a buscar
     * @return Producto
     */
    Optional<Producto> findById(int id);

    /**
     * Buscar un objeto Producto a traves de si mismo
     * 
     * @param producto
     * @return
     */
    Optional<Producto> find(Producto producto);

    /**
     * Listar todas las instacias de Producto
     * 
     * @return Lista con los objetos Producto
     */
    List<Producto> findAll();

    /**
     * Guarda un objeto Producto
     * 
     * @param producto Producto que se quiere guardar
     * @return Producto
     */
    Producto save(Producto producto);

    /**
     * Se borra un objeto Producto a traves de su ID
     * 
     * @param id id del Producto a borrars
     * @return Devuelve true si se borra correctamente
     */
    boolean deleteById(int id);

    /**
     * Se borra un objeto Producto a traves de si mismo
     * 
     * @param producto Producto que se quiere borrar
     * @return Devuelve true si se borra correctamente
     */
    boolean delete(Producto producto);

}
