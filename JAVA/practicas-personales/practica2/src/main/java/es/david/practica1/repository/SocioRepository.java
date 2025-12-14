package es.david.practica1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.david.practica1.model.Socio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Integer> {
    
    // Buscar socio por DNI
    Optional<Socio> findByDni(String dni);
    
    // Buscar socios por nombre (contiene)
    List<Socio> findByNombreCompletoContainingIgnoreCase(String nombre);
    
    // Buscar socios inscritos después de una fecha
    List<Socio> findByFechaInscripcionAfter(LocalDate fecha);
    
    // Buscar socios inscritos en un rango de fechas
    List<Socio> findByFechaInscripcionBetween(LocalDate inicio, LocalDate fin);
    
    // Verificar si existe un socio con un DNI
    boolean existsByDni(String dni);
}

