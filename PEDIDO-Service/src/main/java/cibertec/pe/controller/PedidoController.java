package cibertec.pe.controller;

import cibertec.pe.model.Pedido;
import cibertec.pe.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final IPedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        return pedidoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> guardar(@RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidoService.guardar(pedido), HttpStatus.CREATED);
    }

    // NUEVO: Endpoint para que el Admin actualice el estado (Preparando, Entregado, etc.)
    @PutMapping("/{id}/estado")
    public ResponseEntity<Pedido> actualizarEstado(@PathVariable Long id, @RequestParam String nuevoEstado) {
        Pedido pedido = pedidoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstado(nuevoEstado);
        return ResponseEntity.ok(pedidoService.guardar(pedido));
    }
}