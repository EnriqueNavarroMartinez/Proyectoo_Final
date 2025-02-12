package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.service.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaServiceImpl service;

    @PostMapping
    public ResponseEntity<Categoria> registrar(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(service.registrar(categoria), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return new ResponseEntity<>(service.listarCategorias(), HttpStatus.OK);
    }
}
