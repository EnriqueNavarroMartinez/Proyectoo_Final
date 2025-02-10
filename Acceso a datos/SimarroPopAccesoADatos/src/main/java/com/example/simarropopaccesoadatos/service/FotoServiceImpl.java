package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Foto;
import com.example.simarropopaccesoadatos.entity.Producto;
import com.example.simarropopaccesoadatos.repository.IFotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FotoServiceImpl implements IFotoService{

    @Autowired
    IFotoRepository repository;

    @Override
    public List<Optional<Foto>> listarPorProducto(Producto producto) {
        List<Optional<Foto>> op = repository.listarPorProducto(producto);
        if (!op.isEmpty()) {
                return op;
        } else {
            return null;
        }
    }
}
