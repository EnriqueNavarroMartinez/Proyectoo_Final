package com.example.simarropopaccesoadatos.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "categoria")
public class Categoria {

    @Schema(description = "Identificador de la categoria", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Nombre de la categoria", example = "Inmobiliaria")
    @Column
    @NotNull
    private String nombre;

    @Schema(description = "Descripcion de la categoria", example = "Casas, casetas, garajes, apartamentos...")
    @Column
    private String descripcion;


    public Categoria() {
    }

    public Categoria(Integer id, String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


}

