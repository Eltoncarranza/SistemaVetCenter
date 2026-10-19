package cibertec.pe.service;

import cibertec.pe.model.Medicamento;
import cibertec.pe.repository.IMedicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicamentoService implements IMedicamentoService {

    private final IMedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> listarTodos() { return medicamentoRepository.findAll(); }

    @Override
    public Medicamento guardar(Medicamento medicamento) { return medicamentoRepository.save(medicamento); }

    @Override
    public Optional<Medicamento> buscarPorId(Long id) { return medicamentoRepository.findById(id); }

    @Override
    public void eliminar(Long id) { medicamentoRepository.deleteById(id); }
}