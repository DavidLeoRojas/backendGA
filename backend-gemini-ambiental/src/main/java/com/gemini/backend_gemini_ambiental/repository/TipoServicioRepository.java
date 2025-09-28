package com.gemini.backend_gemini_ambiental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemini.backend_gemini_ambiental.model.TipoServicio;

@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicio, String> {
}

