package com.example.demo.modelo.compra;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime fechaCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id")
    @JsonBackReference("proveedor-compras")
    private Proveedor proveedor;

    @Column(name = "total_compra")
    private Double totalCompra;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference("compra-detalles")
    private List<DetalleCompra> detalles = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void calcularTotalCompra() {

        if (this.detalles == null || this.detalles.isEmpty()) {
            this.totalCompra = 0.0;
        } else {

            double sumaCalculada = 0.0;

            for (DetalleCompra detalle : this.detalles) {
                if (detalle != null && detalle.getSubtotal() != null) {
                    sumaCalculada += detalle.getSubtotal();
                }
            }
            this.totalCompra = sumaCalculada;
        }
    }
}
