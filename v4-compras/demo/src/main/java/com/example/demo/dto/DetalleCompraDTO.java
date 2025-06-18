package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCompraDTO  {

    private ProductoDTORequest productoInfo; // Información para crear/buscar el producto
    private Integer cantidad;
    private Double precioUnitarioCompra;

}
