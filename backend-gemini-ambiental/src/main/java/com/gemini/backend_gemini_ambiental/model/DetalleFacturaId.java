package com.gemini.backend_gemini_ambiental.model;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleFacturaId implements Serializable {

    @Column(name = "ID_factura", length = 36, nullable = false)
    private String idFactura;

    @Column(name = "ID_servicio", length = 36, nullable = false)
    private String idServicio;

    // Constructors
    public DetalleFacturaId() {}

    public DetalleFacturaId(String idFactura, String idServicio) {
        this.idFactura = idFactura;
        this.idServicio = idServicio;
    }

    // Getters and Setters
    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    // equals and hashCode (necesarios para IDs compuestas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleFacturaId)) return false;
        DetalleFacturaId that = (DetalleFacturaId) o;
        return Objects.equals(idFactura, that.idFactura) && Objects.equals(idServicio, that.idServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFactura, idServicio);
    }
}