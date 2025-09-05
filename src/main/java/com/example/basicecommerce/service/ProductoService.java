package com.example.basicecommerce.service;

import com.example.basicecommerce.dto.CrearProductoDTO;
import com.example.basicecommerce.model.Producto;
import com.example.basicecommerce.repository.ProductoRepository;        
import org.springframework.stereotype.Service;

public class ProductoService {
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() { return repo.findAll(); }
}
