package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.entity.Valoracion;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.Optional;

public interface IValoracionService {
    Valoracion registrar(Valoracion valoracion, Integer idUsuario);
    Valoracion modificar(Valoracion valoracion);
    void eliminar(Integer id);
    List<Valoracion> listarValoracionUsuario(Integer idUsuario);
}
