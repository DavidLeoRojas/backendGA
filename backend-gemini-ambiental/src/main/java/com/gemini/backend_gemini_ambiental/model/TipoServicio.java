package com.gemini.backend_gemini_ambiental.model;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@RestController
@RequestMapping("/api/tipos-servicio")
@CrossOrigin(origins = "*") // <-- Permite todos los orígenes (solo para desarrollo)
@Table(name = "tipos_servicio")
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <-- Esta línea es crucial
    @Column(name = "id_tipo_servicio", nullable = false)
    private String idTipoServicio; // Asumiendo que es String. Si es Long, cambia el tipo.

    @Column(name = "nombre_servicio", nullable = false, length = 255)
    private String nombreServicio;

    @Column(name = "categoria", nullable = false, length = 100)
    private String categoria;

    @Column(name = "costo", nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "duracion", nullable = false, length = 50)
    private String duracion;

    @Column(name = "frecuencia", nullable = false, length = 50)
    private String frecuencia;

    @Column(name = "descripcion_extendida", nullable = false, length = 500)
    private String descripcionExtendida;

    @Column(name = "icono", length = 10)
    private String icono;

    // Constructors
    public TipoServicio() {}

    public TipoServicio(String nombreServicio, String categoria, BigDecimal costo, String duracion, String frecuencia, String descripcionExtendida) {
        this.nombreServicio = nombreServicio;
        this.categoria = categoria;
        this.costo = costo;
        this.duracion = duracion;
        this.frecuencia = frecuencia;
        this.descripcionExtendida = descripcionExtendida;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDescripcionExtendida() {
        return descripcionExtendida;
    }

    public void setDescripcionExtendida(String descripcionExtendida) {
        this.descripcionExtendida = descripcionExtendida;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}