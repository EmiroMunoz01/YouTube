package com.example.demo.dto;

import com.example.demo.modelo.compra.Compra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {
    private String nombre;
    private List<CompraDTO> compras;
}
