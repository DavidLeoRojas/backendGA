package com.gemini.backend_gemini_ambiental.controller;



import com.gemini.backend_gemini_ambiental.model.TipoServicio;
import com.gemini.backend_gemini_ambiental.service.TipoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-servicio")
public class TipoServicioController {

    @Autowired
    private TipoServicioService tipoServicioService;

    @GetMapping
    public ResponseEntity<List<TipoServicio>> getAllTiposServicio() {
        List<TipoServicio> tiposServicio = tipoServicioService.findAll();
        return ResponseEntity.ok(tiposServicio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServicio> getTipoServicioById(@PathVariable String id) {
        Optional<TipoServicio> tipoServicio = tipoServicioService.findById(id);
        return tipoServicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createTipoServicio(@RequestBody TipoServicio tipoServicio) {
        try {
            tipoServicioService.save(tipoServicio);
            return ResponseEntity.ok("Tipo de servicio creado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el tipo de servicio: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTipoServicio(@PathVariable String id, @RequestBody TipoServicio tipoServicio) {
        if (!tipoServicioService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoServicio.setIdTipoServicio(id); // Asegura el ID correcto
        try {
            tipoServicioService.save(tipoServicio);
            return ResponseEntity.ok("Tipo de servicio actualizado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el tipo de servicio: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTipoServicio(@PathVariable String id) {
        if (!tipoServicioService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            tipoServicioService.deleteById(id);
            return ResponseEntity.ok("Tipo de servicio eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el tipo de servicio: " + e.getMessage());
        }
    }
}