package es.david.practica1.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(collection = "preferencias")
public class SocioPreferencias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    int socioId;
    String generoFavorito;
    String observaciones;
    LocalDateTime ultimaActualizacion;

    /**
     * Constructor con id
     * 
     * @param id id de las preferencias
     */
    public SocioPreferencias(String id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametros
     * 
     * @param id                  id de las preferencias
     * @param socioId             id del socio
     * @param generoFavorito      genero favorito
     * @param observaciones       observaciones
     * @param ultimaActualizacion ultima actualiazcion
     */
    public SocioPreferencias(String id, int socioId, String generoFavorito, String observaciones,
            LocalDateTime ultimaActualizacion) {
        this.id = id;
        this.socioId = socioId;
        this.generoFavorito = generoFavorito;
        this.observaciones = observaciones;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public SocioPreferencias() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSocioId() {
        return socioId;
    }

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    public String getGeneroFavorito() {
        return generoFavorito;
    }

    public void setGeneroFavorito(String generoFavorito) {
        this.generoFavorito = generoFavorito;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SocioPreferencias other = (SocioPreferencias) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
