package com.inventario.inventario.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompraRequestDTO {

    private Long proveedorId;
    private String numeroFactura;
    private String observaciones;
    private List<CompraDetalleRequestDTO> detalles;
}
