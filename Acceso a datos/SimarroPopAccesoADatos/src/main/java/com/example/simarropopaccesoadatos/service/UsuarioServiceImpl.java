package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.repository.IUsuarioRepository;
import com.example.simarropopaccesoadatos.utils.ModelMapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    IUsuarioRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Usuario registrar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario modificar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return repository.findAll();
    }
    @Override
    public Usuario listarPorId(Integer idUsuario){
        Optional<Usuario> op = repository.findById(idUsuario);

        if (op.isPresent()) {
            Usuario usuario = modelMapper.map(op, Usuario.class);
            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario comprobarUsuario(String correo, String contrasenya) {
        Optional<Usuario> op = repository.comprobarUsuario(correo, contrasenya);
        if (op.isPresent()) {
            Usuario usuario = modelMapper.map(op, Usuario.class);
            return usuario;
        } else {
            return null;
        }
    }
}
