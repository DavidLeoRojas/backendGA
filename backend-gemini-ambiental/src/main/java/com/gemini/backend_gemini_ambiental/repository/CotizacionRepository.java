package com.gemini.backend_gemini_ambiental.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gemini.backend_gemini_ambiental.model.Cotizacion;

@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, String> {
    List<Cotizacion> findByClienteDni(String dniCliente);

    // Ejemplo de consulta personalizada con JOIN
    @Query("SELECT c FROM Cotizacion c JOIN FETCH c.cliente p WHERE p.nombre LIKE %:nombreCliente%")
    List<Cotizacion> findByClienteNombreContaining(@Param("nombreCliente") String nombreCliente);
}