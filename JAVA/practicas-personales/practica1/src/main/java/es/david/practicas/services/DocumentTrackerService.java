package es.david.practicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.david.practicas.models.DocumentTracker;
import es.david.practicas.repository.DocumentTrackerRepository;
import es.david.practicas.services.interfaces.IDocumentTrackerService;

public class DocumentTrackerService implements IDocumentTrackerService {

    @Autowired
    DocumentTrackerRepository documentTrackerRepository;

    @Override
    public Optional<DocumentTracker> findById(Long id) {
        return documentTrackerRepository.findById(id);
    }

    @Override
    public List<DocumentTracker> findAll() {
        return documentTrackerRepository.findAll();
    }

    @Override
    public DocumentTracker save(DocumentTracker documentTracker) {
        return documentTrackerRepository.save(documentTracker);
    }

    @Override
    public boolean deleteById(Long id) {
        documentTrackerRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<DocumentTracker> findByPedidoId(Long pedidoId) {
        return documentTrackerRepository.findByPedidoId(pedidoId);
    }

}
