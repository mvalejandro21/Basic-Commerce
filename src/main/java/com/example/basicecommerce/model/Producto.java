package com.example.basicecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
public class Producto {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable=false) private String nombre;
    @Setter
    @Getter
    @Column(length = 100) private String description;
    @Getter
    @Setter
    @Column(nullable=false, precision = 12, scale = 2) private BigDecimal precio;
    @Setter
    @Getter
    @Column(nullable=false) private int stock;

}
