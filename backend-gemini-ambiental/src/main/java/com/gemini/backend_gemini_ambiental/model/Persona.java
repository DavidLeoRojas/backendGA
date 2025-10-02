package com.gemini.backend_gemini_ambiental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @Column(name = "DNI", length = 20, nullable = false)
    private String dni;

    @Column(name = "tipo_dni", nullable = false)
    private String tipoDni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Email
    @Column(name = "correo", unique = true)
    private String correo;

    @Column(name = "rol", nullable = false) // 'Cliente', 'Empleado'
    private String rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_direccion")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Direccion direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_cargo_especialidad")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CargoEspecialidad cargoEspecialidad;

    // Nuevos campos para manejar Persona Natural y Jurídica
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_persona", nullable = false)
    private TipoPersona tipoPersona = TipoPersona.Natural;

    @Column(name = "nit", length = 20)
    private String nit;

    @Column(name = "representante_legal", length = 20)
    private String representanteLegal;

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

    // Nuevos getters y setters
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    // Enum para tipo de persona    
    public enum TipoPersona {
        Natural, Juridica
    }
}