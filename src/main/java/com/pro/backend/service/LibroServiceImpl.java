package com.pro.backend.service;
import com.pro.backend.model.Libro;
import com.pro.backend.repository.LibroRepository;
import  com.pro.backend.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService{

    private final LibroRepository repository;

    public LibroServiceImpl (LibroRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Libro> listar(){
        return repository.findAll();
    }
    @Override
    public Libro guardar( Libro libro){
        return repository.save(libro);
    }
    @Override
    public Libro actualizar(Libro libro) {

        if (!repository.existsById(libro.getId())) {
            throw new RuntimeException("No se puede ctualizar el libro id:"+libro.getId());
        }
        Libro libroExistente = repository.findById(libro.getId()).get();

        return repository.save(libroExistente);
    }
    @Override
    public void eliminar(Long id){
        if(!repository.existsById(id)){
            throw  new  RuntimeException("No se puede eliminar el libro:"+id+",no existe");
        }
        repository.deleteById(id);
    }


}
