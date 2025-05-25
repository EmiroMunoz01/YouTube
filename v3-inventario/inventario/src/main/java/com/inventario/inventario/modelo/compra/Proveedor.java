package com.inventario.inventario.modelo.compra;

import java.util.List;
import com.inventario.inventario.modelo.Producto;
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
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;


    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

   }
