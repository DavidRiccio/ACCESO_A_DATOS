package es.david.practica1.service.interfaces;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import es.david.practica1.model.Prestamo;

public interface IPrestamoService {
    
    // CRUD básico
    Prestamo crearPrestamo(Prestamo prestamo);
    
    Prestamo crearPrestamoParaSocio(Integer socioId, String tituloLibro);
    
    Optional<Prestamo> obtenerPrestamoPorId(Integer id);
    
    List<Prestamo> obtenerTodosLosPrestamos();
    
    Prestamo actualizarPrestamo(Integer id, Prestamo prestamo);
    
    void eliminarPrestamo(Integer id);
    
    // Métodos adicionales
    List<Prestamo> obtenerPrestamosPorSocio(Integer socioId);
    
    List<Prestamo> buscarPorTituloLibro(String titulo);
    
    List<Prestamo> obtenerPrestamosVencidos();
    
    List<Prestamo> obtenerPrestamosActivosPorSocio(Integer socioId);
    
    List<Prestamo> obtenerPrestamosEntreFechas(LocalDate inicio, LocalDate fin);
    
    long contarPrestamosPorSocio(Integer socioId);
    
    // Método para registrar devolución
    Prestamo registrarDevolucion(Integer prestamoId);
}

