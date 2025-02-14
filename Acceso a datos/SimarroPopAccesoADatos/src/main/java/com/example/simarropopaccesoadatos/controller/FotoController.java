package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Foto;
import com.example.simarropopaccesoadatos.service.FotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    @Autowired
    FotoServiceImpl service;

    @PostMapping("/producto/{idProducto}")
    public ResponseEntity<Foto> registrar(@RequestBody Foto foto, @PathVariable("idProducto")Integer idProducto ){

        if (service.registrar(foto, idProducto) != null) {
            return new ResponseEntity<>(service.registrar(foto, idProducto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public ResponseEntity<Foto> modificar(@RequestBody Foto foto) {
        if (service.modificar(foto) != null ) {
            return new ResponseEntity<>(service.modificar(foto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{idProducto}")
    ResponseEntity<List<Foto>> listarPorIdProducto(@PathVariable("idProducto") Integer idProducto){
        if (service.listarPorIdProducto(idProducto) != null) {
            return new ResponseEntity<>(service.listarPorIdProducto(idProducto),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
