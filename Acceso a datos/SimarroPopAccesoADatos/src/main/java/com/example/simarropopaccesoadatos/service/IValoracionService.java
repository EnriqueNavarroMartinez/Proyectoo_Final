package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.entity.Valoracion;

import java.util.List;
import java.util.Optional;

public interface IValoracionService {
    List<Optional<Valoracion>> listarValoracionUsuario(Usuario usuario);
}
