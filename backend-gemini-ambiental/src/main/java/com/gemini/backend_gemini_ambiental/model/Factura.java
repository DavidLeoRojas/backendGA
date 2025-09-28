package com.gemini.backend_gemini_ambiental.model;

import java.math.BigDecimal;
import java.time.LocalDate; // Importar BigDecimal
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Factura")
public class Factura {

    @Id
    @Column(name = "ID_factura", length = 36)
    private String idFactura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DNI_cliente", nullable = false)
    private Persona cliente;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "monto_total", precision = 12, scale = 2, nullable = false)
    private BigDecimal montoTotal;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoFactura estado = EstadoFactura.Pendiente;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DetalleFactura> detalles = new HashSet<>();

    // Constructors
    public Factura() {}

    public Factura(String idFactura, Persona cliente, LocalDate fechaEmision, BigDecimal montoTotal) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
    }

    // Getters and Setters
    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public EstadoFactura getEstado() {
        return estado;
    }

    public void setEstado(EstadoFactura estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Set<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public enum EstadoFactura {
        Pendiente, Pagada, Vencida, Rechazada
    }
}