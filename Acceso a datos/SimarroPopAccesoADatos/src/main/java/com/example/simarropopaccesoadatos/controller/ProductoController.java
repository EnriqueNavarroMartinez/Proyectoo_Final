package com.example.simarropopaccesoadatos.controller;

import com.example.simarropopaccesoadatos.entity.Categoria;
import com.example.simarropopaccesoadatos.entity.Producto;
import com.example.simarropopaccesoadatos.entity.Usuario;
import com.example.simarropopaccesoadatos.service.ProductoServiceImpl;
import com.example.simarropopaccesoadatos.utils.ModelMapperConfig;
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
import java.util.stream.Collectors;


@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoServiceImpl service;

    @Operation(summary = "Inserta un producto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se inserta el producto",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El usuario no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @PostMapping
    ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
        if (service.registrar(producto) != null) {
            return new ResponseEntity<>(service.registrar(producto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Modifica un producto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se modifica el producto",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "El producto no existe",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class)))
    })
    @PutMapping
    ResponseEntity<Producto> modificar(@RequestBody Producto producto) {
        if (service.modificar(producto) != null) {
            return new ResponseEntity<>(service.modificar(producto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Elimina un producto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se elimina el producto",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            })
    @DeleteMapping("/{id}")
    ResponseEntity eliminar(@PathVariable("id") Integer id){
        service.eliminarPorId(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @Operation(summary = "Listar todos los productos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se listan los productos",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
            })
    @GetMapping("/listarProductos")
    ResponseEntity<List<Producto>> listar() {
        List<Producto> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Operation(summary = "Listar todos los productos por un atributo")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Se listan los productos",
                    content = @Content(schema = @Schema(implementation=ResponseEntity.class))),
    })
    @GetMapping("/listarPorLoQueSea")
    public ResponseEntity<List<Producto>> listarPorNombreCategoriaPrecioUbicacionAntiguedad(@RequestBody(required = false) String nombre, @RequestBody(required = false) Categoria categoria, @RequestBody(required = false) Long precio, @RequestBody(required = false) String ubicacion, @RequestBody(required = false) Long antiguedad) {
        List<Producto> lista = service.listarPorNombreCategoriaPrecioUbicacionAntiguedad(nombre, categoria, precio, ubicacion, antiguedad);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
