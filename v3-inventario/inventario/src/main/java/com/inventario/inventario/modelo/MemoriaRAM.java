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
public class MemoriaRAM extends Producto{

    private double velocidad;
    @Override
    public String getTipoProducto() {
        return "memoria_ram";
    }
}

