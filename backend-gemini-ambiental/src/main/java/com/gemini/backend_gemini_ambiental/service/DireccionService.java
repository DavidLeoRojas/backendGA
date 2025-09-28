package com.gemini.backend_gemini_ambiental.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.Direccion;
import com.gemini.backend_gemini_ambiental.repository.DireccionRepository;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    public Optional<Direccion> findById(String id) {
        return direccionRepository.findById(id);
    }

    public boolean existsById(String id) {
        return direccionRepository.existsById(id);
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public void deleteById(String id) {
        direccionRepository.deleteById(id);
    }
}
