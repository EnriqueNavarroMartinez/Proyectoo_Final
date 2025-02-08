package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Producto;
import com.example.simarropopaccesoadatos.repository.IProductoRepository;
import org.modelmapper.ModelMapper;
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
    ModelMapper modelMapper;

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
    public Producto listarPorId(Integer id) {
        Optional<Producto> op = repository.findById(id);
        if (op.isPresent()) {
            Producto producto = modelMapper.map(op, Producto.class);
            return producto;
        } else {
            return null;
        }
    }

    @Override
    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producto> listarPorNombre(String nombre) {
        List<Optional<Producto>> opLista = repository.listarPorNombre(nombre);
        if (!opLista.isEmpty()) {
           List<Producto> lista = opLista.stream().map(l -> modelMapper.map(opLista, Producto.class)).toList();
            return lista;
        } else {
            return null;
        }
    }
}
