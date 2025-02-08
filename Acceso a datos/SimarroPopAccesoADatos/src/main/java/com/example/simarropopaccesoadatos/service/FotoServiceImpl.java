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
    CategoriaServiceImpl categoriaService;

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
    public Foto registrarEnCategoria(Foto foto, Integer idCategoria) {
        Categoria cat = categoriaService.listarPorId(idCategoria);
        if (cat != null){
            foto.setCategoria(cat);
            return repository.save(foto);
        } else {
            return null;
        }
    }

    @Override
    public List<Foto> listarPorIdProducto(Integer idProducto) {
        List<Optional<Foto>> op = repository.listarPorIdProducto(idProducto);
        if (!op.isEmpty()) {
            List<Foto> lista = op.stream().map(l -> modelMapper.map(op, Foto.class)).toList();
                return lista;
        } else {
            return null;
        }
    }
}
