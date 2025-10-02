package com.gemini.backend_gemini_ambiental.dto;


public class DireccionDTO {
    private String idDireccion;
    private String nombre;
    private String descripcionAdicional;
    private String dependeDe; // nombre o id de la dirección padre


    
    // Getters y Setters

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionAdicional() {
        return descripcionAdicional;
    }

    public void setDescripcionAdicional(String descripcionAdicional) {
        this.descripcionAdicional = descripcionAdicional;
    }

    public String getDependeDe() {
        return dependeDe;
    }

    public void setDependeDe(String dependeDe) {
        this.dependeDe = dependeDe;
    }
}
