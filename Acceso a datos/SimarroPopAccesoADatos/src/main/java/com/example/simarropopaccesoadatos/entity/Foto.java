package com.example.simarropopaccesoadatos.entity;

import jakarta.persistence.*;

@Entity(name = "foto")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String url;

    @Column
    private String descripcio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Foto() {
    }

    public Foto(Integer id, String url, String descripcio, Producto producto) {
        this.id = id;
        this.url = url;
        this.descripcio = descripcio;
        this.producto = producto;
    }
    public Foto(Integer id, String url, String descripcio, Categoria categoria) {
        this.id = id;
        this.url = url;
        this.descripcio = descripcio;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
