package com.pro.backend.service;

import com.pro.backend.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario>listar();
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Usuario usuario);
    void eliminar(Long idUsuario);
}
