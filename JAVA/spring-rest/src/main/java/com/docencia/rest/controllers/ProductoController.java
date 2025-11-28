package com.docencia.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.docencia.rest.domain.Producto;
import com.docencia.rest.exception.ResourceNotFoundException;
import com.docencia.rest.service.impl.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/productos")
@Tag(name = "Productos", description = "Operaciones sobre productos")
public class ProductoController {

    private ProductoService productoService;

    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Get all productos")
    @GetMapping("/")
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @Operation(summary = "Get product by ID")
    @GetMapping("/{id}")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Producto encontrado",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Producto.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Producto no existe",
            content = @Content
        )
    })
    public ResponseEntity<Producto> getProductoById(@PathVariable(value = "id") int productId) {
        Producto producto = productoService.findById(productId).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(producto);
    }


    @Operation(summary = "Delete product by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProductoById(@PathVariable(value = "id") int productId) throws ResourceNotFoundException{
        boolean respuesta =  productoService.deleteById(productId);
        Map<String,Boolean> response = new HashMap<>();
        if (respuesta == false) {
            response.put("deleted", Boolean.FALSE);
            return response;
        }
        
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @Operation(summary = "Insert product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/")
    public Producto createUser(@Valid @RequestBody Producto producto) {
        return productoService.save(producto);
    }



}
