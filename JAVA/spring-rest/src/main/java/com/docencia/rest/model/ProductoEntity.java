package com.docencia.rest.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.docencia.rest.domain.DetalleProducto;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "stock")
    private int stock;
    
    @Column
    private DetalleProducto detalleProducto;

    /*
     * @Column(name = "categoria")
     * private Categoria categoria;
     * 
     */

    /**
     * Constructor vacio
     */
    public ProductoEntity() {
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
    public ProductoEntity(String nombre, BigDecimal precio, int stock,DetalleProducto detalle) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.detalleProducto = detalle;
    }

    public ProductoEntity(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
        public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalle) {
        this.detalleProducto = detalle;
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
        ProductoEntity other = (ProductoEntity) obj;
        return Objects.equals(id, other.id);
    }

}
