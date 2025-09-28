package com.gemini.backend_gemini_ambiental.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cargo_Especialidad")
public class CargoEspecialidad {

    @Id
    @Column(name = "ID_cargo_especialidad", length = 36)
    private String idCargoEspecialidad;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_categoria_servicio")
    private CategoriaServicio categoriaServicio;

    // Constructors
    public CargoEspecialidad() {}

    public CargoEspecialidad(String idCargoEspecialidad, String nombre) {
        this.idCargoEspecialidad = idCargoEspecialidad;
        this.nombre = nombre;
    }

    // Getters and Setters
    public String getIdCargoEspecialidad() {
        return idCargoEspecialidad;
    }

    public void setIdCargoEspecialidad(String idCargoEspecialidad) {
        this.idCargoEspecialidad = idCargoEspecialidad;
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

    public CategoriaServicio getCategoriaServicio() {
        return categoriaServicio;
    }

    public void setCategoriaServicio(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }
}