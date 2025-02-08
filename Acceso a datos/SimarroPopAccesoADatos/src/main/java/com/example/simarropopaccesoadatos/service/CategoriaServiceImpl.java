package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.repository.ICategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    ICategoriaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Categoria registrar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria listarPorId(Integer id) {
        Optional<Categoria> op = repository.findById(id);
        if (op.isPresent()) {
            Categoria categoria = modelMapper.map(op, Categoria.class);
            return categoria;
        } else {
            return null;
        }
    }

    @Override
    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }
}
