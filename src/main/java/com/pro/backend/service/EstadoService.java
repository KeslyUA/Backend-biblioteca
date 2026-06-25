package com.pro.backend.service;

import com.pro.backend.model.Usuario;
import com.pro.backend.repository.UsuarioRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EstadoService {
    private final UsuarioRepository usuarioRepository;

    public EstadoService(UsuarioRepository usuarioRepository){
        this.usuarioRepository= usuarioRepository;
    }

   // @Scheduled(fixedDelay = 300000)
    public  void estado(){
       // LocalDate hoy = LocalDate.now();
      //  List<Usuario> usuariosVencidos = usuarioRepository.usuariosEstadoVencido(hoy);
//for(Usuario usuario: usuariosVencidos){
          //  usuario.setEstado("moroso");
        //}
        // usuarioRepository.saveAll(usuariosVencidos);
    }
}
