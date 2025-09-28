package com.gemini.backend_gemini_ambiental.model;


import java.time.LocalDate;
import java.time.LocalTime;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicio")
public class Servicio {

    @Id
    @Column(name = "ID_servicio", length = 36)
    private String idServicio;

    @OneToOne(fetch = FetchType.LAZY) // Un servicio puede salir de una cotización aprobada
    @JoinColumn(name = "ID_cotizacion")
    private Cotizacion cotizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DNI_empleado_asignado")
    private Persona empleadoAsignado;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "duracion_estimada")
    private String duracionEstimada;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoServicio estado = EstadoServicio.Programado;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ServicioProducto> productosUsados = new HashSet<>();

    // Constructors
    public Servicio() {}

    public Servicio(String idServicio, LocalDate fecha, LocalTime hora) {
        this.idServicio = idServicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters and Setters
    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Persona getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public void setEmpleadoAsignado(Persona empleadoAsignado) {
        this.empleadoAsignado = empleadoAsignado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(String duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public EstadoServicio getEstado() {
        return estado;
    }

    public void setEstado(EstadoServicio estado) {
        this.estado = estado;
    }

    public Set<ServicioProducto> getProductosUsados() {
        return productosUsados;
    }

    public void setProductosUsados(Set<ServicioProducto> productosUsados) {
        this.productosUsados = productosUsados;
    }

    // Enum para el estado
    public enum EstadoServicio {
        Programado, En_Progreso, Completado, Cancelado
    }
}