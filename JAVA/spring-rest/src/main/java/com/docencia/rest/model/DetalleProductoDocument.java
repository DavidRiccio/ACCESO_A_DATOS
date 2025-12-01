package com.docencia.rest.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "producto_detalle")
public class DetalleProductoDocument {
    @Id
    private String id;
    private int productoId;
    private String descripcionLarga;

    /**
     * Constructor vacio
     */
    public DetalleProductoDocument() {
    }

    /**
     * Constructor con la id
     * 
     * @param id id del Detalle
     */
    public DetalleProductoDocument(String id) {
        this.id = id;
    }

    /**
     * Contructor con todos los parametros
     * 
     * @param id               id del detalle
     * @param productoId       id del producto del detalle
     * @param descripcionLarga descricion del producto
     */
    public DetalleProductoDocument(String id, int productoId, String descripcionLarga) {
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

}
