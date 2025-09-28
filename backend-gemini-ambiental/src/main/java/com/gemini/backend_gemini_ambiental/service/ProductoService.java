package com.gemini.backend_gemini_ambiental.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.Producto;
import com.gemini.backend_gemini_ambiental.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(String id) {
        return productoRepository.findById(id);
    }

    public boolean existsById(String id) {
        return productoRepository.existsById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteById(String id) {
        productoRepository.deleteById(id);
    }
}
