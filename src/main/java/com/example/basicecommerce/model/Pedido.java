package com.example.basicecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private LocalDateTime creadoEn;
    @Getter
    @Setter
    @Column(precision=12, scale=2)
    private BigDecimal total;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;
    @Getter
    @Setter
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoItem> items;

    public enum EstadoPedido { CREADO, PAGADO, ENVIADO, CANCELADO }

    // getters & setters
}