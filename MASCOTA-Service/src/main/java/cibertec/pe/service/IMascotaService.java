package cibertec.pe.service;

import cibertec.pe.model.Mascota;
import java.util.List;
import java.util.Optional;

public interface IMascotaService {
    List<Mascota> listarTodas();
    Mascota guardar(Mascota mascota);
    List<Mascota> listarPorCliente(Long clienteId);
    Optional<Mascota> buscarPorId(Long id); // <-- NUEVO MÉTODO
    void eliminar(Long id);                 // <-- NUEVO MÉTODO (Si no lo tienes)
}