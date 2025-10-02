package com.gemini.backend_gemini_ambiental.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column; // Importar BigDecimal
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @Column(name = "ID_producto", length = 36)
    private String idProducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "precio_actual", precision = 12, scale = 2, nullable = false)
    private BigDecimal precioActual;

    @Column(name = "stock", nullable = false)
    private Integer stock = 0;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_categoria_producto", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CategoriaProducto categoriaProducto;

    // Constructors
    public Producto() {}

    public Producto(String idProducto, String nombre, BigDecimal precioActual) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioActual = precioActual;
    }

    // Getters and Setters
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(BigDecimal precioActual) {
        this.precioActual = precioActual;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }
}