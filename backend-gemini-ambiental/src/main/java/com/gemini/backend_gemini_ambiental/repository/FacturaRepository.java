package com.gemini.backend_gemini_ambiental.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemini.backend_gemini_ambiental.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, String> {
    List<Factura> findByClienteDni(String dniCliente);
}