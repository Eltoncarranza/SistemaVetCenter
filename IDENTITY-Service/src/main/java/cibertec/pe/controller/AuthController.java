package cibertec.pe.controller;

import cibertec.pe.model.Usuario;
import cibertec.pe.repository.IUsuarioRepository;
import cibertec.pe.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUsuarioService usuarioService;
    private final IUsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.registrar(usuario), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        boolean exito = usuarioService.login(email, password);

        if (exito) {
            Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
            return ResponseEntity.ok(Map.of(
                    "mensaje", "Login exitoso. ¡Bienvenido a VetCenter!",
                    "rol", usuario.getRol(),
                    "nombre", usuario.getNombre()
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Credenciales incorrectas"));
        }
    }

    // Listar usuarios
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    // Cambiar el rol (con protección para evitar error 500)
    @PutMapping("/hacer-admin")
    public ResponseEntity<?> cambiarRol(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String nuevoRol = request.getOrDefault("rol", "ADMIN");

        try {
            Usuario usuario = usuarioService.cambiarRol(email, nuevoRol);
            return ResponseEntity.ok(Map.of("mensaje", "Rol actualizado correctamente", "nuevoRol", usuario.getRol()));
        } catch (Exception e) {
            // Si el usuario no existe, devolvemos un error 404 limpio
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "No se encontró el usuario con email: " + email));
        }
    }
}