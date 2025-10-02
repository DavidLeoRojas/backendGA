package com.gemini.backend_gemini_ambiental.dto;

import java.util.List;

public class CotizacionDTO {
    private String idCotizacion;
    private String clienteNombre;
    private String fecha;
    private List<DetalleCotizacionDTO> detalles;

    // Getters y Setters
    public String getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(String idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<DetalleCotizacionDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCotizacionDTO> detalles) {
        this.detalles = detalles;
    }
}