package com.pro.backend.dto;
import com.pro.backend.model.Libro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String dni;
    private Long celular;
    private List<Libro> libros;
    private Date fechaPrestado;
    private Date fechaEntrega;
}
