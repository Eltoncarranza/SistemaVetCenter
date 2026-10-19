package cibertec.pe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 100)
    private String presentacion; // NUEVO: Ej. Tableta, Jarabe

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Double precio;

    @Column(length = 50)
    private String categoria; // NUEVO: Antibióticos, etc.

    private Boolean activo = true; // NUEVO: Para el estado
}