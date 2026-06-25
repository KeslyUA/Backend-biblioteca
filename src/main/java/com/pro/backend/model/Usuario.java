package com.pro.backend.model;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String dni;
    private Long celular;

    @ManyToMany
    @JoinTable(
            name = "usuario_libro",
            joinColumns = @JoinColumn(name = "fk_usuario"),
            inverseJoinColumns = @JoinColumn(name = "fk_libro")
    )
    private List<Libro> libros;
    private Date fechaPrestado;
    private Date fechaEntrega;

    public Long getIdUsuario()  {
        return idUsuario ;
    }
    public void setIdUsuario(Long idUsuario){
        this.idUsuario=idUsuario ;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre ;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido ;
    }

    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni = dni ;
    }

    public Long getCelular(){
        return celular ;
    }
    public void setCelular(Long celular){
        this.celular = celular;
    }

    public List<Libro> getLibros(){
        return libros;
    }
    public void setLibros(List<Libro> libros){
        this.libros = libros;
    }

    public Date getFechaPrestado() {
        return fechaPrestado;
    }
    public void setFechaPrestado(Date fechaPrestado) {
        this.fechaPrestado = fechaPrestado;
    }

    public Date getFechaEntrega(){
        return fechaEntrega;
    }
    public  void setFechaEntrega( Date fechaEntrega){
       this.fechaEntrega = fechaEntrega;
    }

    @PrePersist
    protected void onCreate() {
        this.fechaPrestado = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.fechaPrestado);
        calendar.add(Calendar.DAY_OF_YEAR,10);
        this.fechaEntrega = calendar.getTime();
    }
}