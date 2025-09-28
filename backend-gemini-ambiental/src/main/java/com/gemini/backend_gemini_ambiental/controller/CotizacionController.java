package com.gemini.backend_gemini_ambiental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemini.backend_gemini_ambiental.model.Cotizacion;
import com.gemini.backend_gemini_ambiental.service.CotizacionService;

@RestController
@RequestMapping("/api/cotizaciones")
public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    @GetMapping
    public ResponseEntity<List<Cotizacion>> getAllCotizaciones() {
        List<Cotizacion> cotizaciones = cotizacionService.findAll();
        return ResponseEntity.ok(cotizaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cotizacion> getCotizacionById(@PathVariable String id) {
        Optional<Cotizacion> cotizacion = cotizacionService.findById(id);
        return cotizacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createCotizacion(@RequestBody Cotizacion cotizacion) {
        try {
            // Opcional: Validar que el cliente exista
            // if (!personaService.existsById(cotizacion.getCliente().getDni())) {
            //     return ResponseEntity.badRequest().body("Cliente no encontrado.");
            // }
            cotizacionService.save(cotizacion);
            return ResponseEntity.ok("Cotización creada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear la cotización: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCotizacion(@PathVariable String id, @RequestBody Cotizacion cotizacion) {
        if (!cotizacionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cotizacion.setIdCotizacion(id); // Asegura el ID correcto
        try {
            cotizacionService.save(cotizacion);
            return ResponseEntity.ok("Cotización actualizada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar la cotización: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCotizacion(@PathVariable String id) {
        if (!cotizacionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            cotizacionService.deleteById(id);
            return ResponseEntity.ok("Cotización eliminada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar la cotización: " + e.getMessage());
        }
    }
}