package com.gemini.backend_gemini_ambiental.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemini.backend_gemini_ambiental.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, String> {
    List<Servicio> findByEmpleadoAsignadoDni(String dniEmpleado);
    List<Servicio> findByCotizacionIdCotizacion(String idCotizacion); // Servicios de una cotización específica
}