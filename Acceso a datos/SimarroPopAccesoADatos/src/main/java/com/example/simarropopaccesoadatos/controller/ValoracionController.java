package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.entity.Valoracion;
import com.example.simarropopaccesoadatos.service.ValoracionServiceImpl;
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
import java.util.Optional;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {

    @Autowired
    ValoracionServiceImpl service;

    @Operation(summary = "Inserta una valoracion")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se inserta la valoracion",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El usuario no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @PostMapping
    public ResponseEntity<Valoracion> registrar(@RequestBody Valoracion valoracion) {

        if (service.registrar(valoracion) != null){
            return new ResponseEntity<>(service.registrar(valoracion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Modifica una valoracion")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se modifica la valoracion",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El usuario no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @PutMapping
    public ResponseEntity<Valoracion> modificar(@RequestBody Valoracion valoracion) {

        if (service.modificar(valoracion) != null){
            return new ResponseEntity<>(service.modificar(valoracion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Elimina una valoracion")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se elimina la valoracion",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Muestra las valoraciones de un usuario")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se muestran las valoraciones",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El usuario no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
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
