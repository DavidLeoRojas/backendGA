package com.gemini.backend_gemini_ambiental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemini.backend_gemini_ambiental.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
    // Puedes agregar métodos personalizados aquí si los necesitas.
}