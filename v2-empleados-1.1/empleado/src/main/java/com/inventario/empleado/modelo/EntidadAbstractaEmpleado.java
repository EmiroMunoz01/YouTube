package com.inventario.empleado.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EntidadAbstractaEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false, unique = true)
    private Long cedula;

        private Double salario;

    @Enumerated(EnumType.STRING)
    private EnumDepartamento departamento;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fecha_creacion;
}
