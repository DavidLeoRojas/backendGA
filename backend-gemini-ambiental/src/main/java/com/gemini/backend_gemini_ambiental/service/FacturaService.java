package com.gemini.backend_gemini_ambiental.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.Factura;
import com.gemini.backend_gemini_ambiental.repository.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> findById(String id) {
        return facturaRepository.findById(id);
    }

    public boolean existsById(String id) {
        return facturaRepository.existsById(id);
    }

    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    public void deleteById(String id) {
        facturaRepository.deleteById(id);
    }
}