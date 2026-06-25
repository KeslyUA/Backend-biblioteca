package com.pro.backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LibroDTO {
    private Long id;
    private String nombreLibro;
    private String tipo;
    private String autor;
    private Long vecesPrestado = 0L;
    private String imagen;
}
