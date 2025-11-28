package com.docencia.rest.domain;

import java.util.Objects;


public class DetalleProducto {
    private String id;
    private int productoId;
    private String descripcionLarga;

    /**
     * Constructor vacio
     */
    public DetalleProducto() {
    }

    /**
     * Constructor con la id
     * 
     * @param id id del Detalle
     */
    public DetalleProducto(String id) {
        this.id = id;
    }

    /**
     * Contructor con todos los parametros
     * 
     * @param id               id del detalle
     * @param productoId       id del producto del detalle
     * @param descripcionLarga descricion del producto
     */
    public DetalleProducto(String id, int productoId, String descripcionLarga) {
        this.id = id;
        this.productoId = productoId;
        this.descripcionLarga = descripcionLarga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DetalleProducto other = (DetalleProducto) obj;
        return Objects.equals(id, other.id);
    }

}
