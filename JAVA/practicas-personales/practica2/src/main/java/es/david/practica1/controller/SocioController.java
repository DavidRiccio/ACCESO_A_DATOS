package es.david.practica1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.david.practica1.model.Socio;
import es.david.practica1.model.SocioPreferencias;
import es.david.practica1.service.SocioServiceImpl;
import es.david.practica1.service.SocioPreferenciasImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/socios")
@Tag(name = "Socios", description = "Gestión de socios de la biblioteca")
public class SocioController {
    
    @Autowired
    private SocioServiceImpl socioService;
    
    @Autowired
    private SocioPreferenciasImpl socioPreferenciasService;
    
    @Operation(summary = "Obtener todos los socios")
    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        return ResponseEntity.ok(socioService.obtenerTodosLosSocios());
    }
    
    @Operation(summary = "Obtener socio por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Socio> obtenerSocio(
            @Parameter(description = "ID del socio") @PathVariable Integer id) {
        return socioService.obtenerSocioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Operation(summary = "Crear nuevo socio")
    @PostMapping
    public ResponseEntity<Socio> crearSocio(@RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.crearSocio(socio));
    }
    
    @Operation(summary = "Actualizar socio")
    @PutMapping("/{id}")
    public ResponseEntity<Socio> actualizarSocio(
            @Parameter(description = "ID del socio") @PathVariable Integer id,
            @RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.actualizarSocio(id, socio));
    }
    
    @Operation(summary = "Eliminar socio")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSocio(
            @Parameter(description = "ID del socio") @PathVariable Integer id) {
        socioService.eliminarSocio(id);
        return ResponseEntity.noContent().build();
    }
    
    @Operation(summary = "Obtener socio con preferencias de MongoDB")
    @GetMapping("/{id}/completo")
    public ResponseEntity<?> obtenerSocioCompleto(
            @Parameter(description = "ID del socio") @PathVariable Integer id) {
        Socio socio = socioService.obtenerSocioPorId(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));
        
        Optional<SocioPreferencias> preferencias = 
                socioPreferenciasService.obtenerPreferenciasPorSocioId(id);
        
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("socio", socio);
        respuesta.put("preferencias", preferencias.orElse(null));
        
        return ResponseEntity.ok(respuesta);
    }
    
    @Operation(summary = "Crear preferencias para un socio")
    @PostMapping("/{id}/preferencias")
    public ResponseEntity<SocioPreferencias> crearPreferencias(
            @Parameter(description = "ID del socio") @PathVariable Integer id,
            @RequestBody SocioPreferencias preferencias) {
        return ResponseEntity.ok(socioPreferenciasService.crearPreferenciasParaSocio(
                id, 
                preferencias.getGeneroFavorito(), 
                preferencias.getObservaciones()
        ));
    }
}
