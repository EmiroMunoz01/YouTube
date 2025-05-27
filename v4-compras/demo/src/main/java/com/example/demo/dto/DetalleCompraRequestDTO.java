package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleCompraRequestDTO  {
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String nombreProducto;

    private Integer cantidad;
    private Double precioUnitarioCompra;
}
