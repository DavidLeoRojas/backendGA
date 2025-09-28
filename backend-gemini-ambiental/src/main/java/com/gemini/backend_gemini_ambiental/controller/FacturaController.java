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

import com.gemini.backend_gemini_ambiental.model.Factura;
import com.gemini.backend_gemini_ambiental.service.FacturaService;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> getAllFacturas() {
        List<Factura> facturas = facturaService.findAll();
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable String id) {
        Optional<Factura> factura = facturaService.findById(id);
        return factura.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createFactura(@RequestBody Factura factura) {
        try {
            // Opcional: Validar que el cliente exista
            // if (!personaService.existsById(factura.getCliente().getDni())) {
            //     return ResponseEntity.badRequest().body("Cliente no encontrado.");
            // }
            facturaService.save(factura);
            return ResponseEntity.ok("Factura creada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear la factura: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFactura(@PathVariable String id, @RequestBody Factura factura) {
        if (!facturaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        factura.setIdFactura(id); // Asegura el ID correcto
        try {
            facturaService.save(factura);
            return ResponseEntity.ok("Factura actualizada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar la factura: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFactura(@PathVariable String id) {
        if (!facturaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            facturaService.deleteById(id);
            return ResponseEntity.ok("Factura eliminada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar la factura: " + e.getMessage());
        }
    }
}