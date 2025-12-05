package es.david.practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.david.practicas.models.PedidoEntitiy;


@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntitiy, Long>{
    
}
