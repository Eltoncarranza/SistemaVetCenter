package cibertec.pe.service;

import cibertec.pe.model.Usuario;

public interface IUsuarioService {
    Usuario registrar(Usuario usuario);
    boolean login(String email, String password);
    Usuario cambiarRol(String email, String nuevoRol);
}