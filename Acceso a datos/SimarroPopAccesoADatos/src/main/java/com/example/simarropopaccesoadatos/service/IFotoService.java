package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Foto;
import com.example.simarropopaccesoadatos.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IFotoService {
    List<Optional<Foto>> listarPorProducto(Producto producto);
}
