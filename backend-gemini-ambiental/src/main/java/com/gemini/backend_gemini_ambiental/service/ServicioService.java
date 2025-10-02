package com.gemini.backend_gemini_ambiental.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.Servicio;
import com.gemini.backend_gemini_ambiental.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    public Optional<Servicio> findById(String id) {
        return servicioRepository.findById(id);
    }

    public boolean existsById(String id) {
        return servicioRepository.existsById(id);
    }

    public Servicio save(Servicio servicio) {
        // Validar que no se programe en fecha pasada
        if (servicio.getFecha() != null && servicio.getFecha().isBefore(LocalDate.now())) {
            throw new RuntimeException("No se puede programar un servicio en una fecha pasada");
        }
        
        return servicioRepository.save(servicio);
    }

    public void deleteById(String id) {
        // Verificar que no esté en factura o tenga productos asociados
        Servicio servicio = servicioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
            
        // Aquí puedes implementar la lógica para verificar si está en factura
        // o tiene productos asociados antes de eliminar
        
        servicioRepository.deleteById(id);
    }

    public List<Servicio> findByEmpleado(String dniEmpleado) {
        return servicioRepository.findByEmpleadoAsignadoDni(dniEmpleado);
    }

    public List<Servicio> findByCotizacion(String idCotizacion) {
        return servicioRepository.findByCotizacionIdCotizacion(idCotizacion);
    }
}