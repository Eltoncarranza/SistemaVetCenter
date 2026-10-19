package cibertec.pe.controller;

import cibertec.pe.model.Mascota;
import cibertec.pe.service.IMascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {

    private final IMascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<Mascota>> listar() { return ResponseEntity.ok(mascotaService.listarTodas()); }

    // NUEVO: Buscar por ID (Es el que usa el botón Editar)
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscar(@PathVariable Long id) {
        return mascotaService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota) {
        return new ResponseEntity<>(mascotaService.guardar(mascota), HttpStatus.CREATED);
    }

    // NUEVO: Actualizar (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        mascota.setId(id);
        return ResponseEntity.ok(mascotaService.guardar(mascota));
    }

    // NUEVO: Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Mascota>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(mascotaService.listarPorCliente(clienteId));
    }
}