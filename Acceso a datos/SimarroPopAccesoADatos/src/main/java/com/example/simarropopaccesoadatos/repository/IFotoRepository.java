package com.example.simarropopaccesoadatos.repository;

import com.example.simarropopaccesoadatos.entity.Foto;
import com.example.simarropopaccesoadatos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFotoRepository extends JpaRepository<Foto, Integer> {

    @Query("SELECT f FROM foto f WHERE f.producto.id = :idProducto")
    List<Optional<Foto>> listarPorIdProducto(@Param("idProducto") Integer idProducto);
}
