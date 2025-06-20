package com.example.demo.dto;

import com.example.demo.modelo.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTORequest {
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    // No incluimos el ID porque se va a generar o buscar.
}