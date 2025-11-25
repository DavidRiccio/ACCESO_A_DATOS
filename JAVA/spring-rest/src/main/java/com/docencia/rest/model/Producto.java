package com.docencia.rest.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "precio")
    private BigDecimal precio;
    
    @Column(name = "stock")
    private int stock;
    
/*     @Column(name = "categoria")
    private Categoria categoria;
    
    @Column(name = "detalle-producto")
    private DetalleProducto detalle; */

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

    public Producto(int id) {
       this.id = id;
    }

    public void setId(int id){
        this.id =id;
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

}
