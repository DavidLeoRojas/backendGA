package com.gemini.backend_gemini_ambiental.controller;

import java.util.List;
import java.util.Map;
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

import com.gemini.backend_gemini_ambiental.model.CargoEspecialidad;
import com.gemini.backend_gemini_ambiental.model.Direccion;
import com.gemini.backend_gemini_ambiental.model.Persona;
import com.gemini.backend_gemini_ambiental.repository.CargoEspecialidadRepository;
import com.gemini.backend_gemini_ambiental.repository.DireccionRepository;
import com.gemini.backend_gemini_ambiental.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private CargoEspecialidadRepository cargoEspecialidadRepository;

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.findAll();
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/cargos-especialidad")
    public ResponseEntity<List<CargoEspecialidad>> getAllCargosEspecialidad() {
        List<CargoEspecialidad> cargos = cargoEspecialidadRepository.findAll();
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Persona> getPersonaByDni(@PathVariable String dni) {
        Optional<Persona> persona = personaService.findById(dni);
        return persona.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createPersona(@RequestBody Map<String, Object> body) {
        try {
            Persona persona = new Persona();
            persona.setDni((String) body.get("dni"));
            persona.setTipoDni((String) body.get("tipo_dni"));
            persona.setNombre((String) body.get("nombre"));
            persona.setTelefono((String) body.get("telefono"));
            persona.setCorreo((String) body.get("correo"));
            persona.setRol((String) body.get("rol"));

            // Manejar tipo de persona
            if (body.containsKey("tipo_persona")) {
                String tipoPersonaStr = (String) body.get("tipo_persona");
                persona.setTipoPersona(Persona.TipoPersona.valueOf(tipoPersonaStr));
            }

            // Manejar NIT
            if (body.containsKey("nit")) {
                persona.setNit((String) body.get("nit"));
            }

            // Manejar representante legal
            if (body.containsKey("representante_legal")) {
                persona.setRepresentanteLegal((String) body.get("representante_legal"));
            }

            // Mapear la dirección si viene en el body
            if (body.containsKey("id_direccion") && body.get("id_direccion") != null) {
                String idDireccion = (String) body.get("id_direccion");
                Optional<Direccion> direccion = direccionRepository.findById(idDireccion);
                direccion.ifPresent(persona::setDireccion);
            }

            // Mapear el cargo/especialidad si viene en el body
            if (body.containsKey("id_cargo_especialidad") && body.get("id_cargo_especialidad") != null) {
                String idCargo = (String) body.get("id_cargo_especialidad");
                Optional<CargoEspecialidad> cargoEspecialidad = cargoEspecialidadRepository.findById(idCargo);
                cargoEspecialidad.ifPresent(persona::setCargoEspecialidad);
            }

            personaService.save(persona);
            return ResponseEntity.ok("Persona creada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear la persona: " + e.getMessage());
        }
    }

    @PutMapping("/{dni}")
    public ResponseEntity<String> updatePersona(@PathVariable String dni, @RequestBody Map<String, Object> body) {
        Optional<Persona> personaOpt = personaService.findById(dni);

        if (!personaOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        try {
            Persona persona = personaOpt.get();

            // Actualizar solo los campos que vienen en el body
            if (body.containsKey("tipo_dni")) {
                persona.setTipoDni((String) body.get("tipo_dni"));
            }
            if (body.containsKey("nombre")) {
                persona.setNombre((String) body.get("nombre"));
            }
            if (body.containsKey("telefono")) {
                persona.setTelefono((String) body.get("telefono"));
            }
            if (body.containsKey("correo")) {
                persona.setCorreo((String) body.get("correo"));
            }
            if (body.containsKey("rol")) {
                persona.setRol((String) body.get("rol"));
            }
            if (body.containsKey("tipo_persona")) {
                String tipoPersonaStr = (String) body.get("tipo_persona");
                persona.setTipoPersona(Persona.TipoPersona.valueOf(tipoPersonaStr));
            }
            if (body.containsKey("nit")) {
                persona.setNit((String) body.get("nit"));
            }
            if (body.containsKey("representante_legal")) {
                persona.setRepresentanteLegal((String) body.get("representante_legal"));
            }

            // Actualizar dirección si viene en el body
            if (body.containsKey("id_direccion") && body.get("id_direccion") != null) {
                String idDireccion = (String) body.get("id_direccion");
                Optional<Direccion> direccion = direccionRepository.findById(idDireccion);
                direccion.ifPresent(persona::setDireccion);
            }

            // Actualizar cargo/especialidad si viene en el body
            if (body.containsKey("id_cargo_especialidad") && body.get("id_cargo_especialidad") != null) {
                String idCargo = (String) body.get("id_cargo_especialidad");
                Optional<CargoEspecialidad> cargoEspecialidad = cargoEspecialidadRepository.findById(idCargo);
                cargoEspecialidad.ifPresent(persona::setCargoEspecialidad);
            }

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

    // Nuevo endpoint para filtrar por rol
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<Persona>> getPersonasByRol(@PathVariable String rol) {
        List<Persona> personas = personaService.findByRol(rol);
        return ResponseEntity.ok(personas);
    }
}