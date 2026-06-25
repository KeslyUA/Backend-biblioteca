package com.pro.backend.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreLibro;
    private String tipo;
    private String autor;
    private Long vecesPrestado = 0L;
    private String imagen;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreLibro() {
        return nombreLibro;
    }
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Long getVecesPrestado(){
        return vecesPrestado;
    }
    public void setVecesPrestado(Long vecesPrestado){
        this.vecesPrestado = vecesPrestado;
    }
    public String getImagen(){
        return  imagen;
    }
    public void setImagen(String imagen){
        this.imagen =imagen;
    }
}
