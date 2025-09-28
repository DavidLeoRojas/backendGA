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

import com.gemini.backend_gemini_ambiental.model.Servicio;
import com.gemini.backend_gemini_ambiental.service.ServicioService;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> getAllServicios() {
        List<Servicio> servicios = servicioService.findAll();
        return ResponseEntity.ok(servicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable String id) {
        Optional<Servicio> servicio = servicioService.findById(id);
        return servicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createServicio(@RequestBody Servicio servicio) {
        try {
            // Opcional: Validar que el empleado exista
            // if (servicio.getEmpleadoAsignado() != null && !personaService.existsById(servicio.getEmpleadoAsignado().getDni())) {
            //     return ResponseEntity.badRequest().body("Empleado no encontrado.");
            // }
            servicioService.save(servicio);
            return ResponseEntity.ok("Servicio creado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el servicio: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateServicio(@PathVariable String id, @RequestBody Servicio servicio) {
        if (!servicioService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicio.setIdServicio(id); // Asegura el ID correcto
        try {
            servicioService.save(servicio);
            return ResponseEntity.ok("Servicio actualizado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el servicio: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServicio(@PathVariable String id) {
        if (!servicioService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            servicioService.deleteById(id);
            return ResponseEntity.ok("Servicio eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el servicio: " + e.getMessage());
        }
    }
}