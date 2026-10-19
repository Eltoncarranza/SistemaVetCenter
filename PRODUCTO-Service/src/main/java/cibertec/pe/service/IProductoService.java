package cibertec.pe.service;

import cibertec.pe.model.Producto;
import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> listarTodos();
    Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(Long id); // NUEVO
    void eliminar(Long id);                  // NUEVO
}