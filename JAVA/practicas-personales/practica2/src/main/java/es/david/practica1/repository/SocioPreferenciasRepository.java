package es.david.practica1.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.david.practica1.model.SocioPreferencias;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocioPreferenciasRepository extends MongoRepository<SocioPreferencias, String> {
    
    Optional<SocioPreferencias> findBySocioId(Integer socioId);
    
    // Buscar todas las preferencias por género favorito
    List<SocioPreferencias> findByGeneroFavorito(String generoFavorito);
    
    // Buscar preferencias que contengan cierta palabra en observaciones
    List<SocioPreferencias> findByObservacionesContaining(String palabra);
    
    // Verificar si existen preferencias para un socio
    boolean existsBySocioId(Integer socioId);
    
    // Eliminar preferencias por ID de socio
    void deleteBySocioId(Integer socioId);
}

