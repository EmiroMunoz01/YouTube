package com.example.demo.dto;

import com.example.demo.modelo.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTORequest {
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    // No incluimos el ID porque se va a generar o buscar.
}