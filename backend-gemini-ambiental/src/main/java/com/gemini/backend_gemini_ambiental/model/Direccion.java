package com.gemini.backend_gemini_ambiental.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Direccion")
public class Direccion {

    @Id
    @Column(name = "ID_direccion", length = 36)
    private String idDireccion;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion_adicional")
    private String descripcionAdicional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depende_de")
    private Direccion dependeDe;

    // Relación inversa (opcional, para navegación bidireccional)
    @OneToMany(mappedBy = "dependeDe", cascade = CascadeType.ALL)
    private List<Direccion> subDirecciones = new ArrayList<>();

    // Constructors
    public Direccion() {}

    public Direccion(String idDireccion, String nombre) {
        this.idDireccion = idDireccion;
        this.nombre = nombre;
    }

    // Getters and Setters
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

    public Direccion getDependeDe() {
        return dependeDe;
    }

    public void setDependeDe(Direccion dependeDe) {
        this.dependeDe = dependeDe;
    }

    public List<Direccion> getSubDirecciones() {
        return subDirecciones;
    }

    public void setSubDirecciones(List<Direccion> subDirecciones) {
        this.subDirecciones = subDirecciones;
    }
}