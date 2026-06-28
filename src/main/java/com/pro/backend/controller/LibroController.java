package com.pro.backend.controller;
import com.pro.backend.model.Libro;
import com.pro.backend.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("api/libro")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service){

        this.service = service;
    }
    @GetMapping("/lista")
    public List<Libro> listar(){
        return service.listar();
    }
    @PostMapping("/guardar")
    public Libro guardar(@RequestBody Libro libro) {
        return service.guardar(libro);
    }
    @PutMapping("/actualizar/{id}")
    public Libro actualizar(@PathVariable Long id,@RequestBody Libro libro){

        libro.setId(id);
        return  service.actualizar(libro);
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
}
