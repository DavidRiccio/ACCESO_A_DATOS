package es.david.practicas.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(collection = "trackings")
public class DocumentTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private Long pedidoId;
    private String transportista;
    private String numeroSeguimiento;
    private List<EventoTraza> historial = new ArrayList<>();

    /**
     * Constructor con todos los parametros
     * 
     * @param id                id del documento
     * @param pedidoId          id del pedido FK
     * @param transportista     transportista que realiza el transporte
     * @param numeroSeguimiento numero de seguimiento del pedido
     * @param historial         historial de movimientos del pedido
     */
    public DocumentTracker(Long id, Long pedidoId, String transportista, String numeroSeguimiento,
            List<EventoTraza> historial) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.transportista = transportista;
        this.numeroSeguimiento = numeroSeguimiento;
        this.historial = historial;
    }

    public DocumentTracker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }

    public String getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public void setNumeroSeguimiento(String numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }

    public List<EventoTraza> getHistorial() {
        return historial;
    }

    public void setHistorial(List<EventoTraza> historial) {
        this.historial = historial;
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
        DocumentTracker other = (DocumentTracker) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
