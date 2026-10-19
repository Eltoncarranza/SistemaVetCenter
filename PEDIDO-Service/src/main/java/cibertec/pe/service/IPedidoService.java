package cibertec.pe.service;

import cibertec.pe.model.Pedido;
import java.util.List;
import java.util.Optional; // <-- Importante agregar este import

public interface IPedidoService {
    List<Pedido> listarTodos();
    Pedido guardar(Pedido pedido);
    Optional<Pedido> buscarPorId(Long id); // <-- NUEVO MÉTODO
}