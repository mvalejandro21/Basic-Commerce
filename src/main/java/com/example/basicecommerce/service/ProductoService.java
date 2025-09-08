package com.example.basicecommerce.service;

import com.example.basicecommerce.dto.CrearProductoDTO;
import com.example.basicecommerce.model.Producto;
import com.example.basicecommerce.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() { return repo.findAll(); }

    public Producto crear(CrearProductoDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.nombre);
        p.setStock(dto.stock);
        p.setPrecio(dto.precio);
        p.setDescription(dto.descripcion);
        return repo.save(p);
    }

    public Producto obtener(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }

    public Producto actualizar(Long id, CrearProductoDTO dto) {
        Producto p = obtener(id);
        p.setNombre(dto.nombre);
        p.setStock(dto.stock);
        p.setPrecio(dto.precio);
        p.setDescription(dto.descripcion);
        return repo.save(p);
    }
    public void eliminar(Long id) {repo.deleteById(id);}
}
