package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Categoria;
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
        if (service.registrar(producto) != null) {
            return new ResponseEntity<>(service.registrar(producto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    ResponseEntity<Producto> modificar(@RequestBody Producto producto) {
        if (service.modificar(producto) != null) {
            return new ResponseEntity<>(service.modificar(producto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }    }
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
    @GetMapping("/listarPorLoQueSea")
    public ResponseEntity<List<Producto>> listarPorNombreCategoriaPrecioUbicacionAntiguedad(@RequestBody(required = false) String nombre, @RequestBody(required = false) Categoria categoria, @RequestBody(required = false) Long precio, @RequestBody(required = false) String ubicacion, @RequestBody(required = false) Long antiguedad) {
        List<Producto> lista = service.listarPorNombreCategoriaPrecioUbicacionAntiguedad(nombre, categoria, precio, ubicacion, antiguedad);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
