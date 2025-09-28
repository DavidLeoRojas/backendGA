package com.gemini.backend_gemini_ambiental.model;

import java.math.BigDecimal;

import jakarta.persistence.Column; // Importar BigDecimal
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipo_servicio")
public class TipoServicio {

    @Id
    @Column(name = "ID_tipo_servicio", length = 36)
    private String idTipoServicio;

    @Column(name = "nombre_servicio", nullable = false)
    private String nombreServicio;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "costo", precision = 12, scale = 2, nullable = false)
    private BigDecimal costo;

    @Column(name = "frecuencia")
    private String frecuencia;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoServicio estado = EstadoServicio.Activo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_categoria_servicio", nullable = false)
    private CategoriaServicio categoriaServicio;

    // Constructors
    public TipoServicio() {}

    public TipoServicio(String idTipoServicio, String nombreServicio, BigDecimal costo) {
        this.idTipoServicio = idTipoServicio;
        this.nombreServicio = nombreServicio;
        this.costo = costo;
    }

    // Getters and Setters
    public String getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(String idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public EstadoServicio getEstado() {
        return estado;
    }

    public void setEstado(EstadoServicio estado) {
        this.estado = estado;
    }

    public CategoriaServicio getCategoriaServicio() {
        return categoriaServicio;
    }

    public void setCategoriaServicio(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

    public enum EstadoServicio {
        Activo, Inactivo, En_revisionn
    }
}