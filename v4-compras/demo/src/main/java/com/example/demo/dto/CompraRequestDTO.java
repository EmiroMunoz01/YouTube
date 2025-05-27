package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CompraRequestDTO {
    private LocalDateTime fechaCompra;
    private String proveedor;
    // private Long usuarioId; // Si aplica
    private List<DetalleCompraRequestDTO> detalles;


}
