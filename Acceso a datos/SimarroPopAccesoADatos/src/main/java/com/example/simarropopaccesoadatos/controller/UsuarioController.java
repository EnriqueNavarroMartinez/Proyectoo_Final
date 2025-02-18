package com.example.simarropopaccesoadatos.controller;


import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.service.UsuarioServiceImpl;
import com.example.simarropopaccesoadatos.utils.ModelMapperConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Inserta un usuario")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se inserta el usuario",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            })
    @PostMapping
    ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {

        return new ResponseEntity<>(service.registrar(usuario), HttpStatus.OK);
    }

    @Operation(summary = "Modifica un usuario")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se modifica el usuario",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El usuario no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable Integer id, @RequestBody Usuario usuario) {

        if (service.modificar(id, usuario) != null) {
            return new ResponseEntity<>(service.modificar(id, usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @Operation(summary = "Eliminar un usuario")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se elimina el usuario",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            })
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Listar los usuarios")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se listan los usuarios",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            })
    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> listar() {

        return new ResponseEntity<>(service.listar(),HttpStatus.OK);
    }

    @Operation(summary = "Listar usuarios por id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se muestra el usuario",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El usuario no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id) {
        Usuario usuario = service.listarPorId(id);

        if (usuario != null) {
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Comprobar correo y contraseña del usuario")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Existe el usuario",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El usuario no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
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
