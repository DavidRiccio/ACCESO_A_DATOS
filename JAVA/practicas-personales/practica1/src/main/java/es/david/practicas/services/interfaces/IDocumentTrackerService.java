package es.david.practicas.services.interfaces;

import java.util.List;
import java.util.Optional;

import es.david.practicas.models.DocumentTracker;
import es.david.practicas.models.PedidoEntitiy;

public interface IDocumentTrackerService {
    Optional<DocumentTracker> findById(Long id);

    List<DocumentTracker> findAll();

    DocumentTracker save(DocumentTracker documentTracker);

    boolean deleteById(Long id);

    Optional<DocumentTracker> findByPedidoId(Long pedidoId);
}
