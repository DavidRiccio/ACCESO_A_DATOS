package es.david.practica1.service.interfaces;

import java.util.List;
import java.util.Optional;

import es.david.practica1.model.SocioPreferencias;

public interface ISocioPreferenciasService {
    
    // CRUD básico
    SocioPreferencias crearPreferencias(SocioPreferencias preferencias);
    
    SocioPreferencias crearPreferenciasParaSocio(Integer socioId, String generoFavorito, String observaciones);
    
    Optional<SocioPreferencias> obtenerPreferenciasPorId(String id);
    
    List<SocioPreferencias> obtenerTodasLasPreferencias();
    
    SocioPreferencias actualizarPreferencias(String id, SocioPreferencias preferencias);
    
    void eliminarPreferencias(String id);
    
    Optional<SocioPreferencias> obtenerPreferenciasPorSocioId(Integer socioId);
    
    List<SocioPreferencias> buscarPorGeneroFavorito(String genero);
    
    List<SocioPreferencias> buscarPorObservaciones(String palabra);
    
    boolean existenPreferenciasPorSocioId(Integer socioId);
    
    void eliminarPreferenciasPorSocioId(Integer socioId);
    
    SocioPreferencias actualizarPreferenciasPorSocioId(Integer socioId, SocioPreferencias preferencias);
}

