package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    Categoria registrar(Categoria categoria);
    Categoria listarPorId(Integer id);
    List<Categoria> listarCategorias();

}
