package com.gemini.backend_gemini_ambiental.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categoria_producto")
public class CategoriaProducto {

    @Id
    @Column(name = "ID_categoria_producto", length = 36)
    private String idCategoriaProducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    // Constructors
    public CategoriaProducto() {}

    public CategoriaProducto(String idCategoriaProducto, String nombre) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombre = nombre;
    }

    // Getters and Setters
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