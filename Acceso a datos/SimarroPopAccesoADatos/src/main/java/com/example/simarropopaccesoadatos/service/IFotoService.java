package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Foto;
import com.example.simarropopaccesoadatos.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IFotoService {
    Foto registrar(Foto foto, Integer idProducto);
    Foto modificar(Foto foto);
    void eliminar(Integer id);
    List<Foto> listarPorIdProducto(Integer idProducto);
}
