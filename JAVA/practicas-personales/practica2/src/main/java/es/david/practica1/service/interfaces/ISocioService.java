package es.david.practica1.service.interfaces;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import es.david.practica1.model.Socio;

public interface ISocioService {
    
    // CRUD básico
    Socio crearSocio(Socio socio);
    
    Optional<Socio> obtenerSocioPorId(Integer id);
    
    List<Socio> obtenerTodosLosSocios();
    
    Socio actualizarSocio(Integer id, Socio socio);
    
    void eliminarSocio(Integer id);
    
    // Métodos adicionales
    Optional<Socio> buscarPorDni(String dni);
    
    List<Socio> buscarPorNombre(String nombre);
    
    List<Socio> buscarSociosInscritosDesde(LocalDate fecha);
    
    List<Socio> buscarSociosInscritosEntre(LocalDate inicio, LocalDate fin);
    
    boolean existeSocioPorDni(String dni);
    
    // Método que combina datos de H2 y MongoDB
    Socio obtenerSocioConPreferencias(Integer id);
}

