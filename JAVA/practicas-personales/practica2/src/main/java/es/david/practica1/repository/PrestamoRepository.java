package es.david.practica1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.david.practica1.model.Prestamo;
import es.david.practica1.model.Socio;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    
    // Buscar todos los préstamos de un socio
    List<Prestamo> findBySocio(Socio socio);
    
    // Buscar préstamos por ID de socio
    List<Prestamo> findBySocioId(Integer socioId);
    
    // Buscar préstamos por título de libro
    List<Prestamo> findByTituloLibroContainingIgnoreCase(String titulo);
    
    // Buscar préstamos vencidos (fecha de devolución anterior a hoy)
    List<Prestamo> findByFechaDevolucionBefore(LocalDate fecha);
    
    // Buscar préstamos activos de un socio
    @Query("SELECT p FROM Prestamo p WHERE p.socio.id = :socioId AND p.fechaDevolucion >= :hoy")
    List<Prestamo> findPrestamosActivosBySocio(@Param("socioId") Integer socioId, 
                                                @Param("hoy") LocalDate hoy);
    
    // Buscar préstamos realizados en un rango de fechas
    List<Prestamo> findByFechaPrestamoBetween(LocalDate inicio, LocalDate fin);
    
    // Contar préstamos de un socio
    long countBySocioId(Integer socioId);
}

