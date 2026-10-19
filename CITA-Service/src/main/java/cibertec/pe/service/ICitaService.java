package cibertec.pe.service;

import cibertec.pe.model.Cita;
import java.util.List;
import java.util.Optional; // <-- Importante agregar este import

public interface ICitaService {
    List<Cita> listarTodas();
    Cita guardar(Cita cita);
    Optional<Cita> buscarPorId(Long id); // <-- NUEVO MÉTODO
}