package es.david.practica1.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.david.practica1.model.SocioPreferencias;
import es.david.practica1.repository.SocioPreferenciasRepository;
import es.david.practica1.repository.SocioRepository;
import es.david.practica1.service.interfaces.ISocioPreferenciasService;

@Service
public class SocioPreferenciasImpl implements ISocioPreferenciasService {

    @Autowired
    SocioPreferenciasRepository socioPreferenciasRepository;

    @Autowired
    SocioRepository socioRepository;

    @Override
    public SocioPreferencias crearPreferencias(SocioPreferencias preferencias) {
        return socioPreferenciasRepository.save(preferencias);
    }

    @Override
    public SocioPreferencias crearPreferenciasParaSocio(Integer socioId, String generoFavorito, String observaciones) {
        SocioPreferencias socioPreferencias = new SocioPreferencias();
        socioPreferencias.setSocioId(socioId);
        socioPreferencias.setObservaciones(observaciones);
        socioPreferencias.setGeneroFavorito(generoFavorito);
        socioPreferencias.setUltimaActualizacion(LocalDateTime.now());
        return socioPreferenciasRepository.save(socioPreferencias);

    }

    @Override
    public Optional<SocioPreferencias> obtenerPreferenciasPorId(String id) {
        return socioPreferenciasRepository.findById(id);
    }

    @Override
    public List<SocioPreferencias> obtenerTodasLasPreferencias() {
        return socioPreferenciasRepository.findAll();
    }

    @Override
    public SocioPreferencias actualizarPreferencias(String id, SocioPreferencias preferencias) {
        SocioPreferencias socioPreferencias = socioPreferenciasRepository.findById(id).orElse(null);
        socioPreferencias.setGeneroFavorito(preferencias.getGeneroFavorito());
        socioPreferencias.setObservaciones(preferencias.getObservaciones());
        socioPreferencias.setUltimaActualizacion(LocalDateTime.now());
        return socioPreferenciasRepository.save(socioPreferencias);

    }

    @Override
    public void eliminarPreferencias(String id) {
        socioPreferenciasRepository.deleteById(id);
    }

    @Override
    public Optional<SocioPreferencias> obtenerPreferenciasPorSocioId(Integer socioId) {
        return socioPreferenciasRepository.findBySocioId(socioId);
    }

    @Override
    public List<SocioPreferencias> buscarPorGeneroFavorito(String genero) {
        return socioPreferenciasRepository.findByGeneroFavorito(genero);
    }

    @Override
    public List<SocioPreferencias> buscarPorObservaciones(String palabra) {
        return socioPreferenciasRepository.findByObservacionesContaining(palabra);
    }

    @Override
    public boolean existenPreferenciasPorSocioId(Integer socioId) {
        return socioPreferenciasRepository.existsBySocioId(socioId);
    }

    @Override
    public void eliminarPreferenciasPorSocioId(Integer socioId) {
        socioPreferenciasRepository.deleteBySocioId(socioId);
    }

    @Override
    public SocioPreferencias actualizarPreferenciasPorSocioId(Integer socioId, SocioPreferencias preferencias) {
        SocioPreferencias socioPreferencias = socioPreferenciasRepository.findBySocioId(socioId).orElse(null);
        socioPreferencias.setGeneroFavorito(preferencias.getGeneroFavorito());
        socioPreferencias.setObservaciones(preferencias.getObservaciones());
        socioPreferencias.setUltimaActualizacion(LocalDateTime.now());
        return socioPreferenciasRepository.save(socioPreferencias);
    }

}
