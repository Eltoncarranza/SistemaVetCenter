package cibertec.pe.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @Column(nullable = false)
    private Double total;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(length = 50)
    private String estado = "PENDIENTE"; // PENDIENTE, PAGADO, ENVIADO
}