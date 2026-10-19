package cibertec.pe.service;

import cibertec.pe.model.Cita;
import cibertec.pe.repository.ICitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional; // <-- Importante agregar este import

@Service
@RequiredArgsConstructor
public class CitaService implements ICitaService {

    private final ICitaRepository citaRepository;

    @Override
    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    // NUEVO MÉTODO
    @Override
    public Optional<Cita> buscarPorId(Long id) {
        return citaRepository.findById(id);
    }
}