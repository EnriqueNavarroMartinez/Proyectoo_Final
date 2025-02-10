package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    ICategoriaRepository repository;

    @Override
    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }
}
