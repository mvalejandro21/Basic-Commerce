package com.example.basicecommerce.controller;


import com.example.basicecommerce.dto.CrearPedidoDTO;
import com.example.basicecommerce.model.Pedido;
import com.example.basicecommerce.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) { this.service = service; }

    @PostMapping
    public Pedido crear(@Valid @RequestBody CrearPedidoDTO dto) { return service.crearPedido(dto); }

    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Long id) { return service.obtener(id); }
}
