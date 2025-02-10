package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Producto registrar(Producto producto);
    Producto modificar(Producto producto);
    List<Producto> listar();
    void eliminarPorId(Integer id);

    List<Producto> listarPorNombre(String nombre);


}
