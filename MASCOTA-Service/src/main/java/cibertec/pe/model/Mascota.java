package cibertec.pe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String especie;

    @Column(length = 50)
    private String raza;

    @Column(nullable = false)
    private Integer edad;

    // ¡NUEVO CAMPO SEXO!
    @Column(length = 20)
    private String sexo;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;
}