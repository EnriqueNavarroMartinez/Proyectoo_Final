package com.example.simarropopaccesoadatos.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Long antiguedad;

    @Column
    private Long precio;

    @Column
    private String ubicacion;

    @Column
    private boolean deseado = false;

    public Producto() {}

    public Producto(Integer id, Usuario usuario, Categoria categoria, String nombre, String descripcion, Long antiguedad, Long precio, String ubicacion, boolean deseado) {
        this.id = id;
        this.usuario = usuario;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.antiguedad = antiguedad;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.deseado = deseado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Long antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isDeseado() {
        return deseado;
    }

    public void setDeseado(boolean deseado) {
        this.deseado = deseado;
    }


}
