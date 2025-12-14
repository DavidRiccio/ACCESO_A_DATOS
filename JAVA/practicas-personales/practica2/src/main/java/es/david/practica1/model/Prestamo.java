package es.david.practica1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.*;

@Table(name = "prestamos")
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "fechaPrestamo")

    LocalDate fechaPrestamo;
    @Column(name = "fechaDevolucion")
    LocalDate fechaDevolucion;
    @Column(name = "titulo")
    String tituloLibro;
    @Column(name = "fechaRegistro")
    LocalDateTime fechaRegistro;
    @ManyToOne
    Socio socio;

    /**
     * Constructor vacio
     */
    public Prestamo() {
    }

    /**
     * Constructor con id
     * 
     * @param id id del prestamo
     */
    public Prestamo(int id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametros
     * 
     * @param id              id del prestamo
     * @param fechaPrestamo   fecha del prestamo
     * @param fechaDevolucion fecha de la devolucion
     * @param tituloLibro     titulo del libro
     * @param fechaRegistro   fecha del registro
     * @param socio           socio que realizo el prestamo
     */

    public Prestamo(int id, LocalDate fechaPrestamo, LocalDate fechaDevolucion, String tituloLibro,
            LocalDateTime fechaRegistro, Socio socio) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.tituloLibro = tituloLibro;
        this.fechaRegistro = fechaRegistro;
        this.socio = socio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
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
        Prestamo other = (Prestamo) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
