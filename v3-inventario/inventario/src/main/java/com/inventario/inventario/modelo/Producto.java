package com.inventario.inventario.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "")
    private String descripcion;

    @Column(name = "valor_unitario")
    private Double valor_unitario;

    private Integer cantidad;

    @Formula("valor_unitario * cantidad")
    private Double valor_total;


    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

}
