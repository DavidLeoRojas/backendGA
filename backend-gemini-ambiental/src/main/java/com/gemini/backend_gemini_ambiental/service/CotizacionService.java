package com.gemini.backend_gemini_ambiental.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.Cotizacion;
import com.gemini.backend_gemini_ambiental.repository.CotizacionRepository;

@Service
public class CotizacionService {

    @Autowired
    private CotizacionRepository cotizacionRepository;

    public List<Cotizacion> findAll() {
        return cotizacionRepository.findAll();
    }

    public Optional<Cotizacion> findById(String id) {
        return cotizacionRepository.findById(id);
    }

    public boolean existsById(String id) {
        return cotizacionRepository.existsById(id);
    }

    public Cotizacion save(Cotizacion cotizacion) {
        return cotizacionRepository.save(cotizacion);
    }

    public void deleteById(String id) {
        cotizacionRepository.deleteById(id);
    }
}