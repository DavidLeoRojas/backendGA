package com.gemini.backend_gemini_ambiental.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.Servicio;
import com.gemini.backend_gemini_ambiental.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    public Optional<Servicio> findById(String id) {
        return servicioRepository.findById(id);
    }

    public boolean existsById(String id) {
        return servicioRepository.existsById(id);
    }

    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public void deleteById(String id) {
        servicioRepository.deleteById(id);
    }
}
