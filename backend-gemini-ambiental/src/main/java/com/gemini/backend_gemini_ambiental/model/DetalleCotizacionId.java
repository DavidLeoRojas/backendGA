package com.gemini.backend_gemini_ambiental.model;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleCotizacionId implements Serializable {

    @Column(name = "ID_cotizacion", length = 36, nullable = false)
    private String idCotizacion;

    @Column(name = "ID_tipo_servicio", length = 36, nullable = false)
    private String idTipoServicio;

    // Constructors
    public DetalleCotizacionId() {}

    public DetalleCotizacionId(String idCotizacion, String idTipoServicio) {
        this.idCotizacion = idCotizacion;
        this.idTipoServicio = idTipoServicio;
    }

    // Getters and Setters
    public String getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(String idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(String idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    // equals and hashCode (necesarios para IDs compuestas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleCotizacionId)) return false;
        DetalleCotizacionId that = (DetalleCotizacionId) o;
        return Objects.equals(idCotizacion, that.idCotizacion) && Objects.equals(idTipoServicio, that.idTipoServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCotizacion, idTipoServicio);
    }
}