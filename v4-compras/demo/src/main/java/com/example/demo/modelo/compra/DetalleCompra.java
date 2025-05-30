package com.example.demo.modelo.compra;

import com.example.demo.modelo.Producto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "detalle_compra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "compra_id", nullable = false)
    @JsonBackReference("compra-detalles")
    private Compra compra;

    @ManyToOne(fetch = FetchType.LAZY) // No se necesita cascada aquí usualmente, el producto ya debe existir
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario_compra", nullable = false)
    private Double precioUnitarioCompra;

    public Double getSubtotal() {
        if (this.cantidad != null && this.precioUnitarioCompra != null) {
            return this.cantidad * this.precioUnitarioCompra;
        }

        return 0.0;
    }
}
