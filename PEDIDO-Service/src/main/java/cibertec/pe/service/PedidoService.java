package cibertec.pe.service;

import cibertec.pe.model.Pedido;
import cibertec.pe.repository.IPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional; // <-- Importante agregar este import

@Service
@RequiredArgsConstructor
public class PedidoService implements IPedidoService {

    private final IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // NUEVO MÉTODO
    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }
}