package com.example.api.model;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numDetalle;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private int cantidad;

    private double precio;

    // Getter and Setter for numDetalle
    public Long getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(Long numDetalle) {
        this.numDetalle = numDetalle;
    }

    // Getter and Setter for factura
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    // Getter and Setter for producto
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Getter and Setter for cantidad
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Getter and Setter for precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}