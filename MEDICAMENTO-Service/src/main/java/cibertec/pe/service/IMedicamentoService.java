package cibertec.pe.service;

import cibertec.pe.model.Medicamento;
import java.util.List;
import java.util.Optional;

public interface IMedicamentoService {
    List<Medicamento> listarTodos();
    Medicamento guardar(Medicamento medicamento);
    Optional<Medicamento> buscarPorId(Long id); // NUEVO
    void eliminar(Long id);                     // NUEVO
}