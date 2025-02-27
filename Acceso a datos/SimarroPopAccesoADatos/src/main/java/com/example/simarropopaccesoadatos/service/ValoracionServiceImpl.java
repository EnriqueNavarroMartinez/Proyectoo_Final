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
        Usuario usu = usuarioService.listarPorId(valoracion.getUsuario().getId());
        if (usu != null){
            valoracion.setUsuario(usu);
            return repository.save(valoracion);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    //ESTA NO ESTA BIEN -----------------
    @Override
    public List<Valoracion> listarValoracionUsuario(Integer idUsuario) {

        Usuario usu = usuarioService.listarPorId(idUsuario);
        if (usu != null) {
            return repository.listarValoracionUsuario(idUsuario);
        } else {
            return null;
        }
    }
}
