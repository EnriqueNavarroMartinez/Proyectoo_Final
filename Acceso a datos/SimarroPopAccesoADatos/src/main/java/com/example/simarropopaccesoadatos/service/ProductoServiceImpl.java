package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Producto;
import com.example.simarropopaccesoadatos.repository.IProductoRepository;
import com.example.simarropopaccesoadatos.utils.ModelMapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    IProductoRepository repository;

    @Autowired
    ModelMapperConfig modelMapper;

    @Override
    public Producto registrar(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto modificar(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producto> listarPorNombre(String nombre) {
        List<Producto> lista = repository.listarPorNombre(nombre);
        return lista;
    }
}
