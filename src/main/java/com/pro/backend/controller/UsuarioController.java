package com.pro.backend.controller;

import com.pro.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import com.pro.backend.model.Usuario;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioController {

    private final UsuarioService serviceUsuario;

    public UsuarioController(UsuarioService serviceUsuario){
        this.serviceUsuario =serviceUsuario;
    }

    @GetMapping("/listaUsuario")
    public List<Usuario> listar(){
        return  serviceUsuario.listar();
    }

    @PostMapping("/guardarUsuario")
    public Usuario guardar(@RequestBody Usuario usuario){
        return serviceUsuario.guardar(usuario);
    }

    @PutMapping("/actualizar/{idUsuario}")
    public Usuario actualizar(@PathVariable Long idUsuario,@RequestBody Usuario usuario){
        usuario.setIdUsuario(idUsuario);
        return serviceUsuario.actualizar(usuario);
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public void eliminar(@PathVariable Long idUsuario){
        serviceUsuario.eliminar(idUsuario);
    }


}
