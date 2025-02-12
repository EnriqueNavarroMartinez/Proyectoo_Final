package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.entity.Producto;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Producto registrar(Producto producto);
    Producto modificar(Producto producto);
    Producto listarPorId(Integer id);
    List<Producto> listar();
    void eliminarPorId(Integer id);

    List<Producto> listarPorNombreCategoriaPrecioUbicacionAntiguedad(String nombre, Categoria categoria, Long precio, String ubicacion, Long antiguedad);


}
