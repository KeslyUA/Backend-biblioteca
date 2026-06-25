package com.pro.backend.service;

import com.pro.backend.model.Libro;
import com.pro.backend.repository.LibroRepository;
import com.pro.backend.repository.UsuarioRepository;
import com.pro.backend.model.Usuario;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository repository;
    private final LibroRepository libroRepository;
    public UsuarioServiceImpl(UsuarioRepository repository,LibroRepository libroRepository){
        this.repository = repository;
        this.libroRepository = libroRepository;

    }
    @Override
    public List<Usuario>listar(){
        return repository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {

        if (usuario.getLibros() != null) {

            for (Libro libro : usuario.getLibros()) {

                if (libro.getVecesPrestado() == null) {
                    libro.setVecesPrestado(0L);
                }

                libro.setVecesPrestado(libro.getVecesPrestado() + 1);

                libroRepository.save(libro);
            }
        }
        return repository.save(usuario);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {

        if(repository.existsById((usuario.getIdUsuario()))){
            Usuario usuarioExistente = repository.findById(usuario.getIdUsuario()).get();
            usuario.setFechaPrestado(usuarioExistente.getFechaPrestado());
            return repository.save(usuario);
        }
        return null;

    }

    @Override
    public void eliminar(Long idUsuario) {
        if(repository.existsById(idUsuario)){
            repository.deleteById(idUsuario);
        }
    }

}
