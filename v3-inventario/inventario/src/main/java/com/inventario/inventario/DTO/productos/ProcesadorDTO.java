package com.inventario.inventario.DTO.productos;

import com.inventario.inventario.modelo.compra.Proveedor;
import com.inventario.inventario.repositorio.RepositorioProcesador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcesadorDTO {

    private String nombre;
    private String descripcion;
    private Proveedor proveedor;
    private Integer nucleos;

}
