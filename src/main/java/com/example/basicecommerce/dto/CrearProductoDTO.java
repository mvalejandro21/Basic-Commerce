package com.example.basicecommerce.dto;


import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CrearProductoDTO {
    @NotBlank public String nombre;
    public String descripcion;
    @NotNull @DecimalMin("0.0") public BigDecimal precio;
    @NotNull @Min(0) public Integer stock;
}