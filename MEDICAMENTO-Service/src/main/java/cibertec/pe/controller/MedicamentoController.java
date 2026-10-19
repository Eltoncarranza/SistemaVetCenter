package cibertec.pe.controller;

import cibertec.pe.model.Medicamento;
import cibertec.pe.service.IMedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final IMedicamentoService medicamentoService;

    @GetMapping
    public ResponseEntity<List<Medicamento>> listar() { return ResponseEntity.ok(medicamentoService.listarTodos()); }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> buscar(@PathVariable Long id) {
        return medicamentoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medicamento> guardar(@RequestBody Medicamento medicamento) {
        return new ResponseEntity<>(medicamentoService.guardar(medicamento), HttpStatus.CREATED);
    }

    // NUEVO: PUT para editar
    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> actualizar(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        medicamento.setId(id);
        return ResponseEntity.ok(medicamentoService.guardar(medicamento));
    }

    // NUEVO: DELETE para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        medicamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}