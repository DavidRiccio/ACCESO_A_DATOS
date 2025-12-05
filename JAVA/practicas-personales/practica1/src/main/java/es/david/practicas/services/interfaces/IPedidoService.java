package es.david.practicas.services.interfaces;

import java.util.List;
import java.util.Optional;

import es.david.practicas.models.PedidoEntitiy;

public interface IPedidoService {

    /**
     * Busca un pedido a traves de su id
     * 
     * @param id id del pedido
     * @return el pedido o null
     */
    Optional<PedidoEntitiy> findById(Long id);

    /**
     * Lista con todos los Pedidos
     * 
     * @return un List con todos los pedidos
     */
    List<PedidoEntitiy> findAll();

    /**
     * Guarda un pedido
     * 
     * @param pedidoEntitiy el pedido a guardar
     * @return el pedido creado
     */
    PedidoEntitiy save(PedidoEntitiy pedidoEntitiy);


    /**
     * Borra un objeto a traves de su if
     * 
     * @param id id del objeto
     * @return true si lo borras
     */
    boolean deleteById(Long id);
}
