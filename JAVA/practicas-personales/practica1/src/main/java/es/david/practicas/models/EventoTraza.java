package es.david.practicas.models;

import java.time.LocalDateTime;
import java.util.Map;

public class EventoTraza {

    private LocalDateTime fecha;
    private String estado;
    private String ubicacion;
    private String comentario;
    private Map<String, String> detallesExtra;

    public EventoTraza() {
    }

    public LocalDateTime getFecha() {
        return fecha;

    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Map<String, String> getDetallesExtra() {
        return detallesExtra;
    }

    public void setDetallesExtra(Map<String, String> detallesExtra) {
        this.detallesExtra = detallesExtra;
    }

}
