package com.inventario.inventario.modelo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Procesador extends Producto{

    private Integer nucleos;

    @Override
    public String getTipoProducto() {
        return "procesador";
    }
}

