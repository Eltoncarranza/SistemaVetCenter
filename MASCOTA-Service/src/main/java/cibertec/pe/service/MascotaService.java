package cibertec.pe.service;

import cibertec.pe.model.Mascota;
import cibertec.pe.repository.IMascotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MascotaService implements IMascotaService {

    private final IMascotaRepository mascotaRepository;

    @Override
    public List<Mascota> listarTodas() { return mascotaRepository.findAll(); }

    @Override
    public Mascota guardar(Mascota mascota) { return mascotaRepository.save(mascota); }

    @Override
    public List<Mascota> listarPorCliente(Long clienteId) { return mascotaRepository.findByClienteId(clienteId); }

    @Override
    public Optional<Mascota> buscarPorId(Long id) { return mascotaRepository.findById(id); } // <-- NUEVO

    @Override
    public void eliminar(Long id) { mascotaRepository.deleteById(id); } // <-- NUEVO
}