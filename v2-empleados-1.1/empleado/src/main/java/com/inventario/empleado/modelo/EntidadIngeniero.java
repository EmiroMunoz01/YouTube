package com.inventario.empleado.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entidad_ingeniero")
public class EntidadIngeniero extends EntidadAbstractaEmpleado{

    @OneToMany(mappedBy = "ingenieroLider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntidadObrero> obreros = new ArrayList<>();



    @OneToOne(mappedBy = "ingeniero")
    private EntidadAbstractaObraConstruccion obra;

}
