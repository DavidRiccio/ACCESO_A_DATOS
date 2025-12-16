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

    /**
     * Busca un Prestamo por socio
     * 
     * @param socio socio que hizo el prestamo
     * @return Lista de prestamos de ese socio
     */
    List<Prestamo> findBySocio(Socio socio);

    /**
     * Busca por id del socio
     * 
     * @param socioId id del socio
     * @return Lista de prestamos de ese socio
     */
    List<Prestamo> findBySocioId(Integer socioId);

    /**
     * Busca los prestamos a traves de el titulo del libro
     * 
     * @param titulo titulo del libro
     * @return Lista de prestamos
     */
    List<Prestamo> findByTituloLibroContainingIgnoreCase(String titulo);

    /**
     * Busca los prestamos antes de una fecha
     * 
     * @param fecha fecha limite del prestamo
     * @return 
     */
    List<Prestamo> findByFechaDevolucionBefore(LocalDate fecha);
    @Query("SELECT p FROM Prestamo p WHERE p.socio.id = :socioId AND p.fechaDevolucion >= :hoy")
    List<Prestamo> findPrestamosActivosBySocio(@Param("socioId") Integer socioId,
            @Param("hoy") LocalDate hoy);

    List<Prestamo> findByFechaPrestamoBetween(LocalDate inicio, LocalDate fin);

    long countBySocioId(Integer socioId);
}
