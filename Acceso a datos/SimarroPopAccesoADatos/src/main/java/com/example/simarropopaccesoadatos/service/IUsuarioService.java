package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Producto;
import com.example.simarropopaccesoadatos.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    Usuario registrar(Usuario usuario);
    Usuario modificar(Usuario usuario);
    List<Usuario> listar();
    Usuario listarPorId(Integer idUsuario);
    void eliminarPorId(Integer id);

    Usuario comprobarUsuario(String correo, String contrasenya);
}
