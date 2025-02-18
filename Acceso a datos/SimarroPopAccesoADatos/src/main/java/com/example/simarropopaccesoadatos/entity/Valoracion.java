package com.example.simarropopaccesoadatos.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity(name = "valoracion")
public class Valoracion {

    @Schema(description = "Identificador de la valoracion", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Valoracion del producto", example = "9")
    @Column
    private Integer valoracion;

    @Schema(description = "Comentario de la valoracion", example = "Muy buena senial")
    @Column
    private String comentario;

    @Schema(description = "Identificador del usuario al que pertenece la valoracion", example = "1")
    @ManyToOne//(cascade = CascadeType)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Valoracion() {
    }

    public Valoracion(Integer id, Integer valoracion, String comentario) {
        this.id = id;
        this.valoracion = valoracion;
        this.comentario = comentario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
