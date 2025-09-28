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
@Table(name = "detalle_factura")
public class DetalleFactura {

    @EmbeddedId
    private DetalleFacturaId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idFactura")
    @JoinColumn(name = "ID_factura", nullable = false)
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idServicio")
    @JoinColumn(name = "ID_servicio", nullable = false)
    private Servicio servicio;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "precio_unitario", precision = 12, scale = 2, nullable = false)
    private BigDecimal precioUnitario;

    // Constructors
    public DetalleFactura() {
        this.id = new DetalleFacturaId();
    }

    public DetalleFactura(Factura factura, Servicio servicio, BigDecimal precioUnitario) {
        this.id = new DetalleFacturaId(factura.getIdFactura(), servicio.getIdServicio());
        this.factura = factura;
        this.servicio = servicio;
        this.precioUnitario = precioUnitario;
    }

    // Getters and Setters
    public DetalleFacturaId getId() {
        return id;
    }

    public void setId(DetalleFacturaId id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}