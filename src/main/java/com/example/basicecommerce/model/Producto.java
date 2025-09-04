package com.example.basicecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Producto {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false) private String nombre;
    @Column(length = 100) private String description;
    @Column(nullable=false, precision = 12, scale = 2) private BigDecimal precio;
    @Column(nullable=false) private int stock;
}
