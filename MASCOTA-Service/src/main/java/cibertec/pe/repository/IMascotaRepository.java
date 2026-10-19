package cibertec.pe.repository;

import cibertec.pe.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long> {
    // Método extra para buscar mascotas por el ID del cliente
    List<Mascota> findByClienteId(Long clienteId);
}