package com.gemini.backend_gemini_ambiental.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categoria_servicio")
public class CategoriaServicio {

    @Id
    @Column(name = "ID_categoria_servicio", length = 36)
    private String idCategoriaServicio;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    // Constructors
    public CategoriaServicio() {}

    public CategoriaServicio(String idCategoriaServicio, String nombre) {
        this.idCategoriaServicio = idCategoriaServicio;
        this.nombre = nombre;
    }

    // Getters and Setters
    public String getIdCategoriaServicio() {
        return idCategoriaServicio;
    }

    public void setIdCategoriaServicio(String idCategoriaServicio) {
        this.idCategoriaServicio = idCategoriaServicio;
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