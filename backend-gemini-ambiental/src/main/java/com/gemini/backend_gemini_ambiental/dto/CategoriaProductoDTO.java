package com.gemini.backend_gemini_ambiental.dto;

public class CategoriaProductoDTO {
    private String idCategoriaProducto;
    private String nombre;
    private String descripcion;

    // Getters y Setters

    public String getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(String idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
