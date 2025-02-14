package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.entity.Valoracion;
import com.example.simarropopaccesoadatos.service.ValoracionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {

    @Autowired
    ValoracionServiceImpl service;

    @PostMapping()
    public ResponseEntity<Valoracion> registrar(@RequestBody Valoracion valoracion) {

        if (service.registrar(valoracion) != null){
            return new ResponseEntity<>(service.registrar(valoracion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping
    public ResponseEntity<Valoracion> modificar(@RequestBody Valoracion valoracion) {

        if (service.modificar(valoracion) != null){
            return new ResponseEntity<>(service.modificar(valoracion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Valoracion>> listarValoracionUsuario(@PathVariable("id") Integer idUsuario) {
        List<Valoracion> list = service.listarValoracionUsuario(idUsuario);
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
