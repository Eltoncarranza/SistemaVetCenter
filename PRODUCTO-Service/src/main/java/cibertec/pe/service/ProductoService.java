package cibertec.pe.service;

import cibertec.pe.model.Producto;
import cibertec.pe.repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;

    @Override
    public List<Producto> listarTodos() { return productoRepository.findAll(); }

    @Override
    public Producto guardar(Producto producto) { return productoRepository.save(producto); }

    @Override
    public Optional<Producto> buscarPorId(Long id) { return productoRepository.findById(id); }

    @Override
    public void eliminar(Long id) { productoRepository.deleteById(id); }
}