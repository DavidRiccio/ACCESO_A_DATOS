package com.docencia.rest.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {

    private int id;

    private String nombre;
    private DetalleProducto detalleProducto;

    private BigDecimal precio;

    private int stock;


    /**
     * Constructor vacio
     */
    public Producto() {
    }

    

    /**
     * Constructor de Producto con todos los campos
     * 
     * @param nombre    Nombre del producto
     * @param precio    Precio del producto
     * @param stock     Stock del producto
     * @param categoria Categoria del producto
     * @param detalle   Detalle del producto
     */
    public Producto(String nombre, BigDecimal precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(int id, String nombre, DetalleProducto detalleProducto, BigDecimal precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.detalleProducto = detalleProducto;
        this.precio = precio;
        this.stock = stock;
    }



    public Producto(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        Producto other = (Producto) obj;
        return Objects.equals(id, other.id);
    }


    public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

}
