package com.gemini.backend_gemini_ambiental.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cotizacion")
public class Cotizacion {

    @Id
    @Column(name = "ID_cotizacion", length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idCotizacion;

    @Column(name = "DNI_cliente", nullable = false, length = 20)
    private String dniCliente;

    @Column(name = "DNI_empleado", length = 20)
    private String dniEmpleado;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCotizacion estado = EstadoCotizacion.Pendiente;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "fecha_preferida")
    private LocalDate fechaPreferida;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

    @Column(name = "prioridad", length = 50)
    private String prioridad;

    @Column(name = "descripcion_problema", columnDefinition = "TEXT")
    private String descripcionProblema;

    @Column(name = "notas_internas", columnDefinition = "TEXT")
    private String notasInternas;

    @Column(name = "costo_total_cotizacion", precision = 12, scale = 2)
    private BigDecimal costoTotalCotizacion = BigDecimal.ZERO;

    @OneToMany(mappedBy = "cotizacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DetalleCotizacion> detalles = new HashSet<>();

    // AÑADIR RELACIÓN CON PERSONA PARA TRAER DATOS DEL CLIENTE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DNI_cliente", referencedColumnName = "DNI", insertable = false, updatable = false)
    private Persona cliente;

    @PrePersist
    public void prePersist() {
        if (this.fechaSolicitud == null) {
            this.fechaSolicitud = LocalDateTime.now();
        }
        if (this.estado == null) {
            this.estado = EstadoCotizacion.Pendiente;
        }
        if (this.costoTotalCotizacion == null) {
            this.costoTotalCotizacion = BigDecimal.ZERO;
        }
    }

    // Constructors
    public Cotizacion() {}

    public Cotizacion(String idCotizacion, String dniCliente, LocalDateTime fechaSolicitud) {
        this.idCotizacion = idCotizacion;
        this.dniCliente = dniCliente;
        this.fechaSolicitud = fechaSolicitud;
    }

    // Getters and Setters
    public String getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(String idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
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

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public enum EstadoCotizacion {
        Pendiente, Aprobada, Rechazada, Finalizada
    }
}