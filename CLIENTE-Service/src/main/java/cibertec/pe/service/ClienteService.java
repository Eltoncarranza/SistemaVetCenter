package cibertec.pe.service;

import cibertec.pe.model.Cliente;
import cibertec.pe.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final IClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() { return clienteRepository.findAll(); }

    @Override
    public Cliente guardar(Cliente cliente) { return clienteRepository.save(cliente); }

    @Override
    public Optional<Cliente> buscarPorId(Long id) { return clienteRepository.findById(id); }

    @Override
    public void eliminar(Long id) { clienteRepository.deleteById(id); }
}