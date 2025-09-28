package com.gemini.backend_gemini_ambiental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemini.backend_gemini_ambiental.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, String> {
    // JPA ya provee métodos básicos como findAll, findById, save, deleteById, etc.
    // Se pueden agregar métodos personalizados aquí si es necesario.
}
