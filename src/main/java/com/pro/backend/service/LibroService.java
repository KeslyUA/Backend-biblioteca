package com.pro.backend.service;
import com.pro.backend.model.Libro;
import java.util.List;

public interface LibroService {
    List<Libro> listar();
    Libro guardar( Libro libro);
    Libro actualizar(Libro libro);
    void eliminar(Long id);
}
