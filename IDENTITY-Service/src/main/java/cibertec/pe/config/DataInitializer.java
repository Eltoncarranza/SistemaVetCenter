package cibertec.pe.config;

import cibertec.pe.model.Usuario;
import cibertec.pe.repository.IUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(IUsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        // Tus datos exactos
        String correoAdmin = "admin@vetcenter.com";
        String passwordAdmin = "AdminVet2026!";

        // Verificamos si el admin ya existe
        if (usuarioRepository.findByEmail(correoAdmin).isEmpty()) {

            Usuario admin = new Usuario();
            admin.setNombre("Administrador Principal");
            admin.setEmail(correoAdmin);
            // Encripta la contraseña automáticamente con BCrypt
            admin.setPassword(passwordEncoder.encode(passwordAdmin));
            admin.setRol("ADMIN");

            usuarioRepository.save(admin);
            System.out.println("✅ Admin por defecto creado: admin@vetcenter.com / AdminVet2026!");
        } else {
            System.out.println("ℹ️ El admin por defecto ya existe en el sistema.");
        }
    }
}