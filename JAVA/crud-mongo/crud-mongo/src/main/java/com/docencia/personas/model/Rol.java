package com.docencia.personas.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "roles")
public class Rol {
    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    /**
     * Constructor vacio.
     */
    public Rol() {

    }

    /**
     * Constructor de la clase con todos los parametros
     * 
     * @param id Id del rol
     * @param nombre Nombre del rol
     */
    public Rol(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }
    /**
     * Constructor con el identificador del rol
     * @param id Id del rol
     */
    public Rol(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rol other = (Rol) obj;
        return Objects.equals(id, other.id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
