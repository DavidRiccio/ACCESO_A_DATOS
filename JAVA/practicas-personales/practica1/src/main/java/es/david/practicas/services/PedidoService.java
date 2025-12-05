package es.david.practicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.david.practicas.models.PedidoEntitiy;
import es.david.practicas.repository.PedidoRepository;
import es.david.practicas.services.interfaces.IPedidoService;

@Service
public class PedidoService implements IPedidoService{

    @Autowired 
    PedidoRepository pedidoRepository;


    @Override
    public Optional<PedidoEntitiy> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<PedidoEntitiy> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoEntitiy save(PedidoEntitiy pedidoEntitiy) {
        return pedidoRepository.save(pedidoEntitiy);
    }


    @Override
    public boolean deleteById(Long id) {
        pedidoRepository.deleteById(id);
        return true;
    }
    
}
