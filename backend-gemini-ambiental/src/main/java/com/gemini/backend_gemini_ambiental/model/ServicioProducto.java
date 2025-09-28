package com.gemini.backend_gemini_ambiental.model;

import java.math.BigDecimal;

import jakarta.persistence.Column; // Importar BigDecimal
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio_producto")
public class ServicioProducto {

    @EmbeddedId
    private ServicioProductoId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idServicio")
    @JoinColumn(name = "ID_servicio", nullable = false)
    private Servicio servicio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idProducto")
    @JoinColumn(name = "ID_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "precio_actual", precision = 12, scale = 2, nullable = false)
    private BigDecimal precioActual; // Precio del producto en el momento del servicio

    // Constructors
    public ServicioProducto() {
        this.id = new ServicioProductoId();
    }

    public ServicioProducto(Servicio servicio, Producto producto, Integer cantidad, BigDecimal precioActual) {
        this.id = new ServicioProductoId(servicio.getIdServicio(), producto.getIdProducto());
        this.servicio = servicio;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioActual = precioActual;
    }

    // Getters and Setters
    public ServicioProductoId getId() {
        return id;
    }

    public void setId(ServicioProductoId id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(BigDecimal precioActual) {
        this.precioActual = precioActual;
    }
}