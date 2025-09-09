package com.example.basicecommerce.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(unique = true, nullable = false)
    private String username;

    @Getter @Setter
    @Column(nullable = false)
    private String password;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Rol rol;

    public void setRol(String user) {
    }

    public void setPassword(String encode) {
    }

    public enum Rol {
        CLIENTE, ADMIN
    }
}