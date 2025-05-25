package com.inventario.inventario.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class CompraDetalleRequestDTO {
    private String tipoProducto;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Double precioUnitario;
    private Map<String, Object> atributosEspecificos;
}
