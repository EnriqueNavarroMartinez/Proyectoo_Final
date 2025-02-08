package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Foto;
import com.example.simarropopaccesoadatos.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IFotoService {
    Foto registrar(Foto foto, Integer idProducto);
    Foto registrarEnCategoria(Foto foto, Integer idCategoria);
    List<Foto> listarPorIdProducto(Integer idProducto);
}
