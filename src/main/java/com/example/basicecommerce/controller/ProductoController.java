package com.example.basicecommerce.controller;


import com.example.basicecommerce.dto.CrearProductoDTO;
import com.example.basicecommerce.model.Producto;
import com.example.basicecommerce.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) { this.service = service; }

    @GetMapping
    public List<Producto> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) { return service.obtener(id); }

    @PostMapping
    public Producto crear(@Valid @RequestBody CrearProductoDTO dto) { return service.crear(dto); }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @Valid @RequestBody CrearProductoDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
