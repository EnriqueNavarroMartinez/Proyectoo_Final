package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.entity.Foto;
import com.example.simarropopaccesoadatos.entity.Producto;
import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.repository.IFotoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FotoServiceImpl implements IFotoService{

    @Autowired
    IFotoRepository repository;

    @Autowired
    ProductoServiceImpl productoService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Foto registrar(Foto foto, Integer idProducto) {
        Producto prod = productoService.listarPorId(idProducto);
        if (prod != null){
            foto.setProducto(prod);
            return repository.save(foto);
        } else {
            return null;
        }
    }

    @Override
    public Foto modificar(Foto foto) {
        if ( productoService.listarPorId(foto.getProducto().getId()) != null) {
            foto.setProducto(productoService.listarPorId(foto.getProducto().getId()));
            return repository.save(foto);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Foto> listarPorIdProducto(Integer idProducto) {
        if ( productoService.listarPorId(idProducto) != null ) {
            List<Foto> list = repository.listarPorIdProducto(idProducto);
            return list;
        } else {
            return null;
        }
    }
}
