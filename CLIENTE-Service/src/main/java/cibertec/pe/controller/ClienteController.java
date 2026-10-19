package cibertec.pe.controller;

import cibertec.pe.model.Cliente;
import cibertec.pe.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() { return ResponseEntity.ok(clienteService.listarTodos()); }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return clienteService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.guardar(cliente), HttpStatus.CREATED);
    }

    // NUEVO: PUT para editar
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.guardar(cliente));
    }

    // NUEVO: DELETE para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}