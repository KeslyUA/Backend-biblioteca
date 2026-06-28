package com.pro.backend.controller;
import com.pro.backend.model.Usuario;
import org.springframework.http.MediaType;
import com.pro.backend.service.UsuarioService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.nio.charset.StandardCharsets;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
@RestController
@RequestMapping("/api/reporte")
public class ReporteController {

    private final UsuarioService usuarioService;
    public  ReporteController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/descargar")
    public ResponseEntity<Resource> descargarReporte(){
        try{
            StringBuilder csvContenido = new StringBuilder();

            csvContenido.append("Id;Nombre;Apellido;DNI;Celular;Libros;Fecha de prestamo;Fecha limite de entrega\n");

            List<Usuario> listaRegistro = usuarioService.listar();
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

            for(Usuario usuario:listaRegistro){
                csvContenido.append(usuario.getIdUsuario()).append(";")
                        .append(usuario.getNombre()).append(";")
                        .append(usuario.getApellido()).append(";")
                        .append(usuario.getDni()).append(";")
                        .append(usuario.getCelular()).append(";")
                        .append(usuario.getLibros() != null ? usuario.getLibros().size() : 0).append(";")
                        .append(usuario.getFechaPrestado() != null ? formateador.format(usuario.getFechaPrestado()) : "Sin fecha").append(";")
                        .append(usuario.getFechaEntrega() != null ? formateador.format(usuario.getFechaEntrega()) : "Sin fecha").append("\n");

            }

            byte[] bytes = csvContenido.toString().getBytes(StandardCharsets.UTF_8);

            ByteArrayResource recurso =new ByteArrayResource(bytes);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=Reporte_prestamo.csv");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(bytes.length)
                    .contentType(MediaType.parseMediaType("text/csv"))
                    .body(recurso);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
