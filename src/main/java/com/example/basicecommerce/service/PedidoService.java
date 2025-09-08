package com.example.basicecommerce.service;


import com.example.basicecommerce.dto.CrearPedidoDTO;
import com.example.basicecommerce.model.*;
import com.example.basicecommerce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Service
public class PedidoService {
    private final PedidoRepository pedidoRepo;
    private final ProductoRepository productoRepo;
    private final PedidoItemRepository itemRepo;

    public PedidoService(PedidoRepository pedidoRepo, ProductoRepository productoRepo, PedidoItemRepository itemRepo) {
        this.pedidoRepo = pedidoRepo;
        this.productoRepo = productoRepo;
        this.itemRepo = itemRepo;
    }

    @Transactional
    public Pedido crearPedido(CrearPedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setCreadoEn(LocalDateTime.now());
        pedido.setEstado(Pedido.EstadoPedido.CREADO);
        pedido.setItems(new ArrayList<>());
        pedido.setTotal(BigDecimal.ZERO);

        BigDecimal total = BigDecimal.ZERO;

        for (CrearPedidoDTO.Item i : dto.items) {
            Producto prod = productoRepo.findById(i.productoId)
                    .orElseThrow(() -> new IllegalArgumentException("Producto " + i.productoId + " no existe"));

            if (prod.getStock() < i.cantidad) {
                throw new IllegalArgumentException("Stock insuficiente para producto " + prod.getNombre());
            }

            prod.setStock(prod.getStock() - i.cantidad);
            productoRepo.save(prod);

            PedidoItem item = new PedidoItem();
            item.setPedido(pedido);
            item.setProducto(prod);
            item.setCantidad(i.cantidad); // ✅ aquí estaba el error
            item.setPrecioUnitario(prod.getPrecio());
            item.setSubtotal(prod.getPrecio().multiply(BigDecimal.valueOf(i.cantidad)));

            total = total.add(item.getSubtotal());
            pedido.getItems().add(item);
        }

        pedido.setTotal(total);
        Pedido guardado = pedidoRepo.save(pedido);

        // Persistir items (por cascade también funcionaría si está bien mapeado)
        for (PedidoItem it : guardado.getItems()) {
            it.setPedido(guardado);
            itemRepo.save(it);
        }

        return guardado;
    }

    public Pedido obtener(Long id) {
        return pedidoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
    }
}
