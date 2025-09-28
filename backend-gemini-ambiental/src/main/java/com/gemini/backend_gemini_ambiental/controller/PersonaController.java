package com.gemini.backend_gemini_ambiental.controller;


import com.gemini.backend_gemini_ambiental.model.Persona;
import com.gemini.backend_gemini_ambiental.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.findAll();
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Persona> getPersonaByDni(@PathVariable String dni) {
        Optional<Persona> persona = personaService.findById(dni);
        return persona.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createPersona(@RequestBody Persona persona) {
        try {
            personaService.save(persona);
            return ResponseEntity.ok("Persona creada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear la persona: " + e.getMessage());
        }
    }

    @PutMapping("/{dni}")
    public ResponseEntity<String> updatePersona(@PathVariable String dni, @RequestBody Persona persona) {
        if (!personaService.existsById(dni)) {
            return ResponseEntity.notFound().build();
        }
        persona.setDni(dni); // Asegura el ID correcto
        try {
            personaService.save(persona);
            return ResponseEntity.ok("Persona actualizada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar la persona: " + e.getMessage());
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<String> deletePersona(@PathVariable String dni) {
        if (!personaService.existsById(dni)) {
            return ResponseEntity.notFound().build();
        }
        try {
            personaService.deleteById(dni);
            return ResponseEntity.ok("Persona eliminada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar la persona: " + e.getMessage());
        }
    }
}
