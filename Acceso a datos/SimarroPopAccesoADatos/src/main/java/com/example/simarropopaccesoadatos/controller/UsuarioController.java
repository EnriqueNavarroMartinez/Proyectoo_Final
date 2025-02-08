package com.example.simarropopaccesoadatos.controller;


import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.service.UsuarioServiceImpl;
import com.example.simarropopaccesoadatos.utils.ModelMapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioServiceImpl service;

    @PostMapping
    ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {

        return new ResponseEntity<>(service.registrar(usuario), HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<Usuario> modificar(@RequestBody Usuario usuario) {

        return new ResponseEntity<>(service.modificar(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> listar() {

        return new ResponseEntity<>(service.listar(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id) {
        Usuario usuario = service.listarPorId(id);

        if (usuario != null) {
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/comprobar")
    public ResponseEntity<Usuario> comprobarUsuario(@RequestParam("correo") String correo, @RequestParam("contrasenya") String contrasenya) {

        Usuario usu = service.comprobarUsuario(correo, contrasenya);

        if (usu == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(usu, HttpStatus.OK);
        }
    }
}
