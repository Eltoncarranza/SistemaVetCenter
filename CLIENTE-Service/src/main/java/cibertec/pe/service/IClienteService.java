package cibertec.pe.service;

import cibertec.pe.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> listarTodos();
    Cliente guardar(Cliente cliente);
    Optional<Cliente> buscarPorId(Long id); // NUEVO
    void eliminar(Long id);                 // NUEVO
}