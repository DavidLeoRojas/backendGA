package com.gemini.backend_gemini_ambiental.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @Column(name = "DNI", length = 20)
    private String dni;

    @Column(name = "tipo_dni", nullable = false)
    private String tipoDni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo", unique = true)
    private String correo;

    @Column(name = "rol", nullable = false) // 'Cliente', 'Empleado'
    private String rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_direccion")
    private Direccion direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_cargo_especialidad")
    private CargoEspecialidad cargoEspecialidad;

    // Constructors
    public Persona() {}

    public Persona(String dni, String nombre, String rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.rol = rol;
    }

    // Getters and Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(String tipoDni) {
        this.tipoDni = tipoDni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public CargoEspecialidad getCargoEspecialidad() {
        return cargoEspecialidad;
    }

    public void setCargoEspecialidad(CargoEspecialidad cargoEspecialidad) {
        this.cargoEspecialidad = cargoEspecialidad;
    }
}