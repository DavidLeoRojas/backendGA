package com.gemini.backend_gemini_ambiental.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.TipoServicio;
import com.gemini.backend_gemini_ambiental.repository.TipoServicioRepository;

@Service
public class TipoServicioService {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    public List<TipoServicio> findAll() {
        return tipoServicioRepository.findAll();
    }

    public Optional<TipoServicio> findById(String id) {
        return tipoServicioRepository.findById(id);
    }

    public boolean existsById(String id) {
        return tipoServicioRepository.existsById(id);
    }

    public TipoServicio save(TipoServicio tipoServicio) {
        return tipoServicioRepository.save(tipoServicio);
    }

    public void deleteById(String id) {
        tipoServicioRepository.deleteById(id);
    }
}