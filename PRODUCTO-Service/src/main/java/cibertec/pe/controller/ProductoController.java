package cibertec.pe.controller;

import cibertec.pe.model.Producto;
import cibertec.pe.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() { return ResponseEntity.ok(productoService.listarTodos()); }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Long id) {
        return productoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.guardar(producto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // NUEVO: Endpoint para Activar/Desactivar un producto
    @PutMapping("/{id}/estado")
    public ResponseEntity<Producto> cambiarEstado(@PathVariable Long id) {
        Producto producto = productoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Invierte el valor actual (si es true lo pone false y viceversa)
        producto.setActivo(!producto.getActivo());
        return ResponseEntity.ok(productoService.guardar(producto));
    }
}