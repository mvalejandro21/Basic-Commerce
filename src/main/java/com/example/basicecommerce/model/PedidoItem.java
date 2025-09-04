package com.example.basicecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class PedidoItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false) @JoinColumn(name="pedido_id")
    private Pedido pedido;

    @ManyToOne(optional=false) @JoinColumn(name="producto_id")
    private Producto producto;

    @Column(nullable=false) private Integer cantidad;
    @Column(precision=12, scale=2) private BigDecimal precioUnitario;
    @Column(precision=12, scale=2) private BigDecimal subtotal;

    // getters & setters
}