package com.gemini.backend_gemini_ambiental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.Persona;
import com.gemini.backend_gemini_ambiental.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(String dni) {
        return personaRepository.findById(dni);
    }

    public boolean existsById(String dni) {
        return personaRepository.existsById(dni);
    }

    public Persona save(Persona persona) {
        // Validar tipo de persona
        if (persona.getTipoPersona() == Persona.TipoPersona.Juridica) {
            if (persona.getNit() == null || persona.getNit().isEmpty()) {
                throw new RuntimeException("Para persona jurídica, el NIT es obligatorio");
            }
            // El DNI se convierte en el NIT para jurídicas
            persona.setDni(persona.getNit());
        } else {
            if (persona.getNit() != null && !persona.getNit().isEmpty()) {
                throw new RuntimeException("La persona natural no debe tener NIT");
            }
        }
        
        return personaRepository.save(persona);
    }

    public void deleteById(String dni) {
        personaRepository.deleteById(dni);
    }

    public List<Persona> findByRol(String rol) {
        return personaRepository.findAll().stream()
                .filter(p -> p.getRol().equalsIgnoreCase(rol))
                .toList();
    }
}