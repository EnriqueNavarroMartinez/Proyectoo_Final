package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.service.CategoriaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Inserta una categoria")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se inserta la categoria",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
    })
    @PostMapping
    public ResponseEntity<Categoria> registrar(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(service.registrar(categoria), HttpStatus.OK);
    }

    @Operation(summary = "Muestra una lista de valoraciones")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se muestra la lista de categorias",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
           })
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return new ResponseEntity<>(service.listarCategorias(), HttpStatus.OK);
    }
}
