package com.example.simarropopaccesoadatos.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "producto")
public class Producto {

    @Schema(description = "Identificador del producto", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Identificador del usuario que ha publicacdo el producto", example = "1")
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Schema(description = "Identificador de la categoria del producto", example = "1")
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Schema(description = "Nombre del producto", example = "Estroboscopio")
    @Column
    private String nombre;

    @Schema(description = "Descripcion del producto", example = "Aparatejo que estroboscopea")
    @Column
    private String descripcion;

    @Schema(description = "Antiguedad del producto", example = "3")
    @Column
    private Long antiguedad;

    @Schema(description = "Precio unitario del producto", example = "29")
    @Column
    private Long precio;

    @Schema(description = "Ubicacion del producto", example = "Barcelona")
    @Column
    private String ubicacion;

    @Schema(description = "Es un producto favorito?", example = "false")
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
