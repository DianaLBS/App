package com.example.api.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroFactura;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "factura")
    private List<Detalle> detalles;

    // Getter and Setter for numeroFactura
    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    // Getter and Setter for cliente
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Getter and Setter for fecha
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Getter and Setter for detalles
    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}
