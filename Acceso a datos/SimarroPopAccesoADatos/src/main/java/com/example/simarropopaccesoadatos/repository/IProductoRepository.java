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

    @Query("SELECT p FROM producto p WHERE p.nombre = :nombre")
    List<Producto> listarPorNombre(@Param("nombre") String nombre);

}
