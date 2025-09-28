package com.gemini.backend_gemini_ambiental.model;

import java.math.BigDecimal;
import java.time.LocalDate; // Importar BigDecimal
import java.time.LocalDateTime;
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
@Table(name = "Cotizacion")
public class Cotizacion {

    @Id
    @Column(name = "ID_cotizacion", length = 36)
    private String idCotizacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DNI_cliente", nullable = false)
    private Persona cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DNI_empleado")
    private Persona empleado;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCotizacion estado = EstadoCotizacion.Pendiente;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "fecha_preferida")
    private LocalDate fechaPreferida;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "descripcion_problema", columnDefinition = "TEXT")
    private String descripcionProblema;

    @Column(name = "notas_internas", columnDefinition = "TEXT")
    private String notasInternas;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "costo_total_cotizacion", precision = 12, scale = 2)
    private BigDecimal costoTotalCotizacion;

    @OneToMany(mappedBy = "cotizacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DetalleCotizacion> detalles = new HashSet<>();

    // Constructors
    public Cotizacion() {}

    public Cotizacion(String idCotizacion, Persona cliente, LocalDateTime fechaSolicitud) {
        this.idCotizacion = idCotizacion;
        this.cliente = cliente;
        this.fechaSolicitud = fechaSolicitud;
    }

    // Getters and Setters
    public String getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(String idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Persona getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Persona empleado) {
        this.empleado = empleado;
    }

    public EstadoCotizacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoCotizacion estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaPreferida() {
        return fechaPreferida;
    }

    public void setFechaPreferida(LocalDate fechaPreferida) {
        this.fechaPreferida = fechaPreferida;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }

    public BigDecimal getCostoTotalCotizacion() {
        return costoTotalCotizacion;
    }

    public void setCostoTotalCotizacion(BigDecimal costoTotalCotizacion) {
        this.costoTotalCotizacion = costoTotalCotizacion;
    }

    public Set<DetalleCotizacion> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetalleCotizacion> detalles) {
        this.detalles = detalles;
    }

    public enum EstadoCotizacion {
        Pendiente, Aprobada, Rechazada, Finalizada
    }
}