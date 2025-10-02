package com.gemini.backend_gemini_ambiental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemini.backend_gemini_ambiental.model.CategoriaProducto;
import com.gemini.backend_gemini_ambiental.service.CategoriaProductoService;

/**
 * Controlador para gestionar las operaciones CRUD de las categorías de producto.
 */
@RestController
@RequestMapping("/api/categorias-producto")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    /**
     * Obtiene todas las categorías de producto.
     *
     * @return Una lista de todas las categorías de producto.
     */
    @GetMapping
    public ResponseEntity<List<CategoriaProducto>> getAllCategorias() {
        List<CategoriaProducto> categorias = categoriaProductoService.findAll();
        return ResponseEntity.ok(categorias);
    }

    /**
     * Obtiene una categoría de producto por su ID.
     *
     * @param id El ID de la categoría a buscar.
     * @return La categoría de producto si se encuentra, o un estado 404 si no.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProducto> getCategoriaById(@PathVariable String id) {
        var categoria = categoriaProductoService.findById(id);
        return categoria.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea una nueva categoría de producto.
     *
     * @param categoria La categoría de producto a crear.
     * @return Un mensaje de éxito o error.
     */
    @PostMapping
    public ResponseEntity<String> createCategoria(@RequestBody CategoriaProducto categoria) {
        try {
            categoriaProductoService.save(categoria);
            return ResponseEntity.ok("Categoría creada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear la categoría: " + e.getMessage());
        }
    }

    /**
     * Actualiza una categoría de producto existente.
     *
     * @param id      El ID de la categoría a actualizar.
     * @param categoria Los nuevos datos de la categoría.
     * @return Un mensaje de éxito o error.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategoria(@PathVariable String id, @RequestBody CategoriaProducto categoria) {
        if (!categoriaProductoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        // Aseguramos que el ID en el objeto sea el correcto
        categoria.setIdCategoriaProducto(id);
        try {
            categoriaProductoService.save(categoria);
            return ResponseEntity.ok("Categoría actualizada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar la categoría: " + e.getMessage());
        }
    }

    /**
     * Elimina una categoría de producto.
     *
     * @param id El ID de la categoría a eliminar.
     * @return Un mensaje de éxito o error.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable String id) {
        if (!categoriaProductoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            categoriaProductoService.deleteById(id);
            return ResponseEntity.ok("Categoría eliminada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar la categoría: " + e.getMessage());
        }
    }
}