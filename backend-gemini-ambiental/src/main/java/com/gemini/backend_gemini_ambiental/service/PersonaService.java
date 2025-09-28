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
        return personaRepository.findAll(); // Ahora devuelve List<Persona>
    }

    public Optional<Persona> findById(String dni) {
        return personaRepository.findById(dni); // Ahora devuelve Optional<Persona>
    }

    public boolean existsById(String dni) {
        return personaRepository.existsById(dni);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deleteById(String dni) {
        personaRepository.deleteById(dni);
    }
}