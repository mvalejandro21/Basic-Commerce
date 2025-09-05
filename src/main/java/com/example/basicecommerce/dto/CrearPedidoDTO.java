package com.example.basicecommerce.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class CrearPedidoDTO {
    @NotEmpty public List<Item> items;

    public static class Item {
        @NotNull public Long productoId;
        @NotNull @Min(1) public Integer cantidad;
    }
}