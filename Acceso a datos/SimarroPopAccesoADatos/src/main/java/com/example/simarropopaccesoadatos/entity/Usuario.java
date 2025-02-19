package com.example.simarropopaccesoadatos.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity(name = "usuario")
public class Usuario {

    @Schema(description = "Identificador del usuario", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Nombre del usuario", example = "Manolo")
    @Column
    private String nombre;

    @Schema(description = "Correo del usuario", example = "manolo69@ejemplo.es")
    @Column
    @Email(message = "Email incorrecto")
    private String correo;

    @Schema(description = "Contrasenya del usuario", example = "contrasenya1234")
    @Column
    @Size(min= 4, message = "La contrasenya debe tener minimo 4 caracteres")
    private String contrasenya;

    @Schema(description = "Numero de telefono del usuario", example = "626 101 989")
    @Column
    private String numTelefono;

    @Schema(description = "Es un usuario premium?", example = "false")
    @Column
    private boolean premium = false;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correo, String contrasenya, String numTelefono, boolean premium) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenya = contrasenya;
        this.numTelefono = numTelefono;
        this.premium = premium;
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

    public boolean isPremium() {
        return premium;
    }
    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
