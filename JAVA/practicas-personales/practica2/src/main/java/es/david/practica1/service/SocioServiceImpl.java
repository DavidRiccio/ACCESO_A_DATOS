package es.david.practica1.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.david.practica1.model.Socio;
import es.david.practica1.model.SocioPreferencias;
import es.david.practica1.repository.SocioRepository;
import es.david.practica1.service.interfaces.ISocioService;

@Service
public class SocioServiceImpl implements ISocioService {

    @Autowired
    SocioRepository socioRepository;

    @Autowired
    private SocioPreferenciasImpl socioPreferenciasService;

    @Override
    public Socio crearSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    @Override
    public Optional<Socio> obtenerSocioPorId(Integer id) {
        return socioRepository.findById(id);
    }

    @Override
    public List<Socio> obtenerTodosLosSocios() {
        return socioRepository.findAll();
    }

    @Override
    public Socio actualizarSocio(Integer id, Socio socio) {
        Socio newSocio = socioRepository.findById(id).orElse(null);
        newSocio.setDni(socio.getDni());
        newSocio.setNombreCompleto(socio.getNombreCompleto());
        newSocio.setFechaInscripcion(socio.getFechaInscripcion());
        return socioRepository.save(newSocio);

    }

    @Override
    public void eliminarSocio(Integer id) {
        socioRepository.deleteById(id);
    }

    @Override
    public Optional<Socio> buscarPorDni(String dni) {
        return socioRepository.findByDni(dni);
    }

    @Override
    public List<Socio> buscarPorNombre(String nombre) {
        return socioRepository.findByNombreCompletoContainingIgnoreCase(nombre);
    }

    @Override
    public List<Socio> buscarSociosInscritosDesde(LocalDate fecha) {
        return socioRepository.findByFechaInscripcionAfter(fecha);
    }

    @Override
    public List<Socio> buscarSociosInscritosEntre(LocalDate inicio, LocalDate fin) {
        return socioRepository.findByFechaInscripcionBetween(inicio, fin);
    }

    @Override
    public boolean existeSocioPorDni(String dni) {
        return socioRepository.existsByDni(dni);
    }

    @Override
    public Socio obtenerSocioConPreferencias(Integer id) {
        Socio socio = socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado con ID: " + id));

        SocioPreferencias preferencias = socioPreferenciasService.obtenerPreferenciasPorSocioId(id).orElse(null);
        return socio;
    }

}
