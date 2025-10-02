package com.gemini.backend_gemini_ambiental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemini.backend_gemini_ambiental.model.CategoriaProducto;
import com.gemini.backend_gemini_ambiental.repository.CategoriaProductoRepository;

@Service
public class CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    public List<CategoriaProducto> findAll() {
        return categoriaProductoRepository.findAll();
    }

    public Optional<CategoriaProducto> findById(String id) {
        return categoriaProductoRepository.findById(id);
    }

    public CategoriaProducto save(CategoriaProducto categoria) {
        return categoriaProductoRepository.save(categoria);
    }

    public boolean existsById(String id) {
        return categoriaProductoRepository.existsById(id);
    }

    public void deleteById(String id) {
        categoriaProductoRepository.deleteById(id);
    }
}