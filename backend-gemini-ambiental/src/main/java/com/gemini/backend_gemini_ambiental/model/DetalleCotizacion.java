package com.gemini.backend_gemini_ambiental.model;

import java.math.BigDecimal;

import jakarta.persistence.Column; // Importar BigDecimal
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "Detalle_Cotizacion")
public class DetalleCotizacion {

    @EmbeddedId
    private DetalleCotizacionId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idCotizacion")
    @JoinColumn(name = "ID_cotizacion", nullable = false)
    private Cotizacion cotizacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idTipoServicio")
    @JoinColumn(name = "ID_tipo_servicio", nullable = false)
    private TipoServicio tipoServicio;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad = 1;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "precio_unitario", precision = 12, scale = 2, nullable = false)
    private BigDecimal precioUnitario;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "costos_extra", precision = 12, scale = 2)
    private BigDecimal costosExtra = BigDecimal.ZERO; // Inicializar con BigDecimal.ZERO

    @Column(name = "descripcion_costos_extra", columnDefinition = "TEXT")
    private String descripcionCostosExtra;

    // Cambiar Double a BigDecimal y usar precision y scale
    @Column(name = "subtotal", precision = 12, scale = 2, nullable = false)
    private BigDecimal subtotal; // Calculado

    // Constructors
    public DetalleCotizacion() {
        this.id = new DetalleCotizacionId();
    }

    public DetalleCotizacion(Cotizacion cotizacion, TipoServicio tipoServicio) {
        this.id = new DetalleCotizacionId(cotizacion.getIdCotizacion(), tipoServicio.getIdTipoServicio());
        this.cotizacion = cotizacion;
        this.tipoServicio = tipoServicio;
    }

    // Getters and Setters
    public DetalleCotizacionId getId() {
        return id;
    }

    public void setId(DetalleCotizacionId id) {
        this.id = id;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getCostosExtra() {
        return costosExtra;
    }

    public void setCostosExtra(BigDecimal costosExtra) {
        this.costosExtra = costosExtra;
    }

    public String getDescripcionCostosExtra() {
        return descripcionCostosExtra;
    }

    public void setDescripcionCostosExtra(String descripcionCostosExtra) {
        this.descripcionCostosExtra = descripcionCostosExtra;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    // Calcula subtotal antes de persistir o actualizar
    @PrePersist
    @PreUpdate
    private void calcularSubtotal() {
        if (this.precioUnitario != null && this.cantidad != null) {
            BigDecimal subtotalCalculado = this.precioUnitario.multiply(new BigDecimal(this.cantidad));
            if (this.costosExtra != null) {
                subtotalCalculado = subtotalCalculado.add(this.costosExtra);
            }
            this.subtotal = subtotalCalculado;
        }
    }
}