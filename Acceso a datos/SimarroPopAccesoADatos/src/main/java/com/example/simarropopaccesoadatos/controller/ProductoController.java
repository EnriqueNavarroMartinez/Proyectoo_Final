package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Producto;
import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.service.ProductoServiceImpl;
import com.example.simarropopaccesoadatos.utils.ModelMapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoServiceImpl service;

    @PostMapping
    ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
        return new ResponseEntity<>(service.registrar(producto), HttpStatus.OK);
    }
    @PutMapping
    ResponseEntity<Producto> modificar(@RequestBody Producto producto) {
        return new ResponseEntity<>(service.modificar(producto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity eliminar(@PathVariable("id") Integer id){
        service.eliminarPorId(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/listarProductos")
    ResponseEntity<List<Producto>> listar() {
        List<Producto> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<List<Producto>> listarPorNombre(@PathVariable("nombre") String nombre) {
        List<Producto> lista = service.listarPorNombre(nombre);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
