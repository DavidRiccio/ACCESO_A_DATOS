package es.david.practicas.models;

import java.time.LocalDateTime;

import es.david.practicas.models.enums.EstadoPedido;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "productos")
public class PedidoEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String cliente;
    LocalDateTime fechaPedido;
    EstadoPedido estado;
    double total;

    /**
     * Constructor con todos los parametros
     * 
     * @param id          id del pedido
     * @param cliente     cliente que realizo el pedido
     * @param fechaPedido fecha en la que se realizos
     * @param estado      estado del pedido
     * @param total       precio total del pedido
     */
    public PedidoEntitiy(Long id, String cliente, LocalDateTime fechaPedido, EstadoPedido estado, double total) {
        this.id = id;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.total = total;
    }

    /**
     * Constructor vacioss
     */
    public PedidoEntitiy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        PedidoEntitiy other = (PedidoEntitiy) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
