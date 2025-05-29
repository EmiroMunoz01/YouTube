package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleCompraDTO  {

    private ProductoDTORequest productoInfo; // Información para crear/buscar el producto

    private Integer cantidad;
    private Double precioUnitarioCompra;
}
