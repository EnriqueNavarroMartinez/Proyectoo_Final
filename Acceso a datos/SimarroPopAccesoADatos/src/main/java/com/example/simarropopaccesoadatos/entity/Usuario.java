package com.example.simarropopaccesoadatos.entity;

import jakarta.persistence.*;

@Entity(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String correo;

    @Column
    private String contrasenya;

    @Column
    private String numTelefono;


    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correo, String contrasenya, String numTelefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.numTelefono = numTelefono;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
}
