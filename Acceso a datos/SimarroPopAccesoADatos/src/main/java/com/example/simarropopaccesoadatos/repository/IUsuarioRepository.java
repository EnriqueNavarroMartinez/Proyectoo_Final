package com.example.simarropopaccesoadatos.repository;

import com.example.simarropopaccesoadatos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM usuario u WHERE u.correo = :correo AND u.contrasenya = :contrasenya")
    Optional<Usuario> comprobarUsuario(@Param("correo") String correo, @Param("contrasenya") String contrasenya);
}
