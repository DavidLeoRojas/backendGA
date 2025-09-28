package com.gemini.backend_gemini_ambiental.model;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ServicioProductoId implements Serializable {

    @Column(name = "ID_servicio", length = 36, nullable = false)
    private String idServicio;

    @Column(name = "ID_producto", length = 36, nullable = false)
    private String idProducto;

    // Constructors
    public ServicioProductoId() {}

    public ServicioProductoId(String idServicio, String idProducto) {
        this.idServicio = idServicio;
        this.idProducto = idProducto;
    }

    // Getters and Setters
    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    // equals and hashCode (necesarios para IDs compuestas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServicioProductoId)) return false;
        ServicioProductoId that = (ServicioProductoId) o;
        return Objects.equals(idServicio, that.idServicio) && Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, idProducto);
    }
}