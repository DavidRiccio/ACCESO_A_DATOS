package es.david.practica1.model;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "socios")
@Entity
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "dni", unique = true)
    String dni;

    @Column(name = "nombre")
    String nombreCompleto;

    @Column(name = "fechaInscripcion")
    LocalDate fechaInscripcion;
    @Schema(hidden = true) 
    @OneToMany
    List<Prestamo> prestamos;

    /**
     * Constructor vacio
     */
    public Socio() {
    }

    /**
     * Constructor con id
     * 
     * @param id
     */
    public Socio(int id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametrosS
     * 
     * @param id               id del socio
     * @param dni              dni del socio
     * @param nombreCompleto   nombre completo del socio
     * @param fechaInscripcion fecha de inscripcion del socio
     * @param prestamos        lista de prestamos de un socio
     */
    public Socio(int id, String dni, String nombreCompleto, LocalDate fechaInscripcion, List<Prestamo> prestamos) {
        this.id = id;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.fechaInscripcion = fechaInscripcion;
        this.prestamos = prestamos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Socio other = (Socio) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
