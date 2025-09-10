package com.example.basicecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
public class PedidoItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne(optional=false) @JoinColumn(name="pedido_id")
    private Pedido pedido;
    @Getter
    @Setter
    @ManyToOne(optional=false) @JoinColumn(name="producto_id")
    private Producto producto;
    @Getter
    @Setter
    @Column(nullable=false) private Integer cantidad;
    @Getter
    @Setter
    @Column(precision=12, scale=2) private BigDecimal precioUnitario;
    @Getter
    @Setter
    @Column(precision=12, scale=2) private BigDecimal subtotal;



    // getters & setters
}