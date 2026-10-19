package cibertec.pe.controller;

import cibertec.pe.model.Cita;
import cibertec.pe.service.ICitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final ICitaService citaService;

    @GetMapping
    public ResponseEntity<List<Cita>> listar() { return ResponseEntity.ok(citaService.listarTodas()); }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscar(@PathVariable Long id) {
        return citaService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cita> guardar(@RequestBody Cita cita) {
        return new ResponseEntity<>(citaService.guardar(cita), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Cita> actualizarEstado(@PathVariable Long id, @RequestParam String nuevoEstado) {
        Cita cita = citaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setEstado(nuevoEstado);
        return ResponseEntity.ok(citaService.guardar(cita));
    }
}