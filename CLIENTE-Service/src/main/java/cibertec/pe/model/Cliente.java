package cibertec.pe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(length = 15)
    private String telefono;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 255)
    private String direccion;
}