package es.david.practica1.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.david.practica1.model.Prestamo;
import es.david.practica1.model.Socio;
import es.david.practica1.repository.PrestamoRepository;
import es.david.practica1.repository.SocioRepository;
import es.david.practica1.service.interfaces.IPrestamoService;

@Service
public class PrestamosServiceImpl implements IPrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    SocioRepository socioRepository;

    @Override
    public Prestamo crearPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo crearPrestamoParaSocio(Integer socioId, String tituloLibro) {
        Socio socio = socioRepository.findById(socioId).orElse(null);
        Prestamo prestamo = new Prestamo();
        prestamo.setSocio(socio);
        prestamo.setTituloLibro(tituloLibro);
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.setFechaDevolucion(LocalDate.now().plusDays(15));
        prestamo.setFechaRegistro(LocalDateTime.now());

        return prestamoRepository.save(prestamo);
    }

    @Override
    public Optional<Prestamo> obtenerPrestamoPorId(Integer id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo actualizarPrestamo(Integer id, Prestamo prestamo) {
        Prestamo newPrestamo = prestamoRepository.findById(id).orElse(null);
        newPrestamo.setTituloLibro(prestamo.getTituloLibro());
        newPrestamo.setFechaDevolucion(prestamo.getFechaDevolucion());
        newPrestamo.setFechaPrestamo(prestamo.getFechaPrestamo());
        newPrestamo.setFechaRegistro(prestamo.getFechaRegistro());
        return prestamoRepository.save(newPrestamo);
    }

    @Override
    public void eliminarPrestamo(Integer id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public List<Prestamo> obtenerPrestamosPorSocio(Integer socioId) {
        return prestamoRepository.findBySocioId(socioId);
    }

    @Override
    public List<Prestamo> buscarPorTituloLibro(String titulo) {
        return prestamoRepository.findByTituloLibroContainingIgnoreCase(titulo);
    }

    @Override
    public List<Prestamo> obtenerPrestamosVencidos() {
        LocalDate hoy = LocalDate.now();
        return prestamoRepository.findByFechaDevolucionBefore(hoy);
    }

    @Override
    public List<Prestamo> obtenerPrestamosActivosPorSocio(Integer socioId) {
        LocalDate hoy = LocalDate.now();
        return prestamoRepository.findPrestamosActivosBySocio(socioId, hoy);
    }

    @Override
    public List<Prestamo> obtenerPrestamosEntreFechas(LocalDate inicio, LocalDate fin) {
        return prestamoRepository.findByFechaPrestamoBetween(inicio, fin);
    }

    @Override
    public long contarPrestamosPorSocio(Integer socioId) {
        return prestamoRepository.countBySocioId(socioId);
    }

    @Override
    public Prestamo registrarDevolucion(Integer prestamoId) {
        Prestamo prestamo = prestamoRepository.findById(prestamoId).orElse(null);
        prestamo.setFechaDevolucion(LocalDate.now());
        return prestamoRepository.save(prestamo);

    }

}
