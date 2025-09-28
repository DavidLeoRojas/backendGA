package com.gemini.backend_gemini_ambiental.controller;



import com.gemini.backend_gemini_ambiental.model.Producto;
import com.gemini.backend_gemini_ambiental.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable String id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createProducto(@RequestBody Producto producto) {
        try {
            productoService.save(producto);
            return ResponseEntity.ok("Producto creado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el producto: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable String id, @RequestBody Producto producto) {
        if (!productoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        producto.setIdProducto(id); // Asegura el ID correcto
        try {
            productoService.save(producto);
            return ResponseEntity.ok("Producto actualizado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el producto: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable String id) {
        if (!productoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            productoService.deleteById(id);
            return ResponseEntity.ok("Producto eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el producto: " + e.getMessage());
        }
    }
}