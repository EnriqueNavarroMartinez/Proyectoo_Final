package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.entity.Valoracion;
import com.example.simarropopaccesoadatos.repository.IValoracionRepository;
import jakarta.persistence.Access;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ValoracionServiceImpl implements IValoracionService{

    @Autowired
    IValoracionRepository repository;

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Valoracion registrar(Valoracion valoracion) {
        Usuario usu = usuarioService.listarPorId(valoracion.getUsuario().getId());
        if (usu != null){
            valoracion.setUsuario(usu);
            return repository.save(valoracion);
        } else {
            return null;
        }
    }

    @Override
    public Valoracion modificar(Valoracion valoracion) {
        return repository.save(valoracion);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Valoracion> listarValoracionUsuario(Integer idUsuario) {
        List<Optional<Valoracion>> op = repository.listarValoracionUsuario(idUsuario);
        if (op.isEmpty()) {
            return null;
        } else {
            List<Valoracion> lista = op.stream().map(l -> modelMapper.map(op, Valoracion.class)).collect(Collectors.toList());
            return lista;
        }
    }
}
