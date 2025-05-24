package com.inventario.empleado.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entidad_obrero")
public class EntidadObrero extends EntidadAbstractaEmpleado{

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "ingeniero_id", nullable  = true)
    private EntidadIngeniero ingenieroLider;



    @Enumerated(EnumType.STRING)
    private EnumVehiculo vehiculo;

}
