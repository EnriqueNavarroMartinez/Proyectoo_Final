package com.example.simarropopaccesoadatos.repository;


import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.entity.Producto;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p FROM producto p WHERE (p.nombre = :nombre OR p.nombre = null) AND (p.categoria = :categoria OR p.categoria = null) AND (p.precio = :precio OR p.precio = null) AND (p.ubicacion = :ubicacion OR p.ubicacion = null) AND (p.antiguedad = :antiguedad OR p.antiguedad = null) ")
    List<Optional<Producto>> listarPorNombreCategoriaPrecioUbicacionAntiguedad(@Param("nombre") String nombre, @Param("categoria") Categoria categoria, @Param("precio") Long precio, @Param("ubicacion") String ubicacion, @Param("antiguedad") Long antiguedad);

}
