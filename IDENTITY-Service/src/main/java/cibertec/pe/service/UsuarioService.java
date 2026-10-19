package cibertec.pe.service;

import cibertec.pe.model.Usuario;
import cibertec.pe.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Usuario registrar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean login(String email, String password) {
        return usuarioRepository.findByEmail(email)
                .map(usuario -> passwordEncoder.matches(password, usuario.getPassword()))
                .orElse(false);
    }

    @Override
    public Usuario cambiarRol(String email, String nuevoRol) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el email: " + email));
        usuario.setRol(nuevoRol);
        return usuarioRepository.save(usuario);
    }
}