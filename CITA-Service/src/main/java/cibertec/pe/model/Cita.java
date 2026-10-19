package cibertec.pe.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false, length = 255)
    private String motivo;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "mascota_id", nullable = false)
    private Long mascotaId;

    @Column(length = 50)
    private String estado = "PENDIENTE";
}