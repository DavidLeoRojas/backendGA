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

import com.gemini.backend_gemini_ambiental.model.Direccion;
import com.gemini.backend_gemini_ambiental.service.DireccionService;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> getAllDirecciones() {
        List<Direccion> direcciones = direccionService.findAll();
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getDireccionById(@PathVariable String id) {
        Optional<Direccion> direccion = direccionService.findById(id);
        return direccion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createDireccion(@RequestBody Direccion direccion) {
        try {
            direccionService.save(direccion);
            return ResponseEntity.ok("Dirección creada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear la dirección: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDireccion(@PathVariable String id, @RequestBody Direccion direccion) {
        if (!direccionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        direccion.setIdDireccion(id); // Asegura el ID correcto
        try {
            direccionService.save(direccion);
            return ResponseEntity.ok("Dirección actualizada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar la dirección: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDireccion(@PathVariable String id) {
        if (!direccionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            direccionService.deleteById(id);
            return ResponseEntity.ok("Dirección eliminada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar la dirección: " + e.getMessage());
        }
    }
}