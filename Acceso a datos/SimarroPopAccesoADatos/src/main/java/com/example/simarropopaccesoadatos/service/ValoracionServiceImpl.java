package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.entity.Valoracion;
import com.example.simarropopaccesoadatos.repository.IValoracionRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValoracionServiceImpl implements IValoracionService{

    @Autowired
    IValoracionRepository repository;

    @Override
    public List<Optional<Valoracion>> listarValoracionUsuario(Usuario usuario) {
        List<Optional<Valoracion>> op = repository.listarValoracionUsuario(usuario);
        if (!op.isEmpty()) {
            return op;
        } else {
            return null;
        }
    }
}
