package com.example.simarropopaccesoadatos.repository;


import com.example.simarropopaccesoadatos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
