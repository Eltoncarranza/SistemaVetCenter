package cibertec.pe.repository;

import cibertec.pe.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicamentoRepository extends JpaRepository<Medicamento, Long> {
}