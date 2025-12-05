package es.david.practicas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.david.practicas.models.DocumentTracker;
import java.util.List;
import java.util.Optional;


@Repository
public interface DocumentTrackerRepository extends MongoRepository<DocumentTracker, Long> {

    Optional<DocumentTracker> findByPedidoId(Long pedidoId); 
}
