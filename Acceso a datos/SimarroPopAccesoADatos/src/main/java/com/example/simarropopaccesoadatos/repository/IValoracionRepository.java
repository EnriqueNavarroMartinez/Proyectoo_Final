package com.example.simarropopaccesoadatos.repository;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IValoracionRepository extends JpaRepository<Valoracion, Integer> {

    @Query("SELECT v FROM valoracion v WHERE v.usuario = :usuario")
    List<Optional<Valoracion>> listarValoracionUsuario(@Param("usuario") Usuario usuario);
}
