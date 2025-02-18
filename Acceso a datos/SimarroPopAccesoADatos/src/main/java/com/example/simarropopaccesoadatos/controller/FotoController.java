package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Foto;
import com.example.simarropopaccesoadatos.service.FotoServiceImpl;
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
@RequestMapping("/fotos")
public class FotoController {

    @Autowired
    FotoServiceImpl service;

    @Operation(summary = "Registra un producto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se registra la foto en el producto",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El producto no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @PostMapping("/producto/{idProducto}")
    public ResponseEntity<Foto> registrar(@RequestBody Foto foto, @PathVariable("idProducto")Integer idProducto ){

        if (service.registrar(foto, idProducto) != null) {
            return new ResponseEntity<>(service.registrar(foto, idProducto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Operation(summary = "Modifica una foto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se modifica la foto",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "La foto no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @PutMapping
    public ResponseEntity<Foto> modificar(@RequestBody Foto foto) {
        if (service.modificar(foto) != null ) {
            return new ResponseEntity<>(service.modificar(foto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Elimina una foto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se elimina la foto",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            })
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Listar las fotos de un producto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se listan las fotos de un producto",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El producto no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @GetMapping("/{idProducto}")
    ResponseEntity<List<Foto>> listarPorIdProducto(@PathVariable("idProducto") Integer idProducto){
        if (service.listarPorIdProducto(idProducto) != null) {
            return new ResponseEntity<>(service.listarPorIdProducto(idProducto),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
