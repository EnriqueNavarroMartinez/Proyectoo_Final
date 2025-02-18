package com.example.simarropopaccesoadatos.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity(name = "foto")
public class Foto {

    @Schema(description = "Identificador de la foto", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Ubicacion de la foto", example = "./imagenes/producto1/imagen1.png")
    @Column
    private String url;

    @Schema(description = "Breve descripcion de la foto", example = "Foto delantera del estroboscopio")
    @Column
    private String descripcio;

    @Schema(description = "Identificador del producto al que pertenece la foto", example = "1")
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Foto() {
    }

    public Foto(Integer id, String url, String descripcio, Producto producto) {
        this.id = id;
        this.url = url;
        this.descripcio = descripcio;
        this.producto = producto;
    }
    public Foto(Integer id, String url, String descripcio) {
        this.id = id;
        this.url = url;
        this.descripcio = descripcio;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
