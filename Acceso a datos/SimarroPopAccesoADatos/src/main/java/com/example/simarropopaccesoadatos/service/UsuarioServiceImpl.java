package com.example.simarropopaccesoadatos.service;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    IUsuarioRepository repository;

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
    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario comprobarUsuario(String correo, String contrasenya) {
        Usuario usuario = repository.comprobarUsuario(correo, contrasenya);
        return usuario;
    }
}
