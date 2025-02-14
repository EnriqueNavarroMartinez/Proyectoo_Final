package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.entity.Producto;
import com.example.simarropopaccesoadatos.entity.Usuario;
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
    UsuarioServiceImpl usuarioService;

    @Autowired
    CategoriaServiceImpl categoriaService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Producto registrar(Producto producto) {
        Usuario usuario = usuarioService.listarPorId(producto.getUsuario().getId());
        Categoria categoria = categoriaService.listarPorId(producto.getCategoria().getId());
        if (usuario != null && categoria != null) {
            producto.setUsuario(usuario);
            producto.setCategoria(categoria);
            return repository.save(producto);
        } else {
            return null;
        }
    }

    @Override
    public Producto modificar(Producto producto) {
        Usuario usuario = usuarioService.listarPorId(producto.getUsuario().getId());
        Categoria categoria = categoriaService.listarPorId(producto.getCategoria().getId());
        if (usuario != null && categoria != null) {
            producto.setUsuario(usuario);
            producto.setCategoria(categoria);
            return repository.save(producto);
        } else {
            return null;
        }
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }
    @Override
    public Producto listarPorId(Integer id) {
        Optional<Producto> op = repository.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
            return null;
        }
    }

    @Override
    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }

    //ESTA NO ESTA BIEN -----------------
    @Override
    public List<Producto> listarPorNombreCategoriaPrecioUbicacionAntiguedad(String nombre, Categoria categoria, Long precio, String ubicacion, Long antiguedad) {

        List<Optional<Producto>> opList= repository.listarPorNombreCategoriaPrecioUbicacionAntiguedad(nombre, categoria, precio, ubicacion, antiguedad);
        if (!opList.isEmpty()) {
            List<Producto> lista = opList.stream().map(l -> modelMapper.map(opList, Producto.class)).toList();
            return lista;
        } else {
            return null;
        }
    }
}
