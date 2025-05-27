package com.example.demo.modelo.compra;

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
    @JoinColumn(name = "proveedor_id", nullable = true)
    private Proveedor proveedor;

    @Column(name = "total_compra")
    private Double totalCompra;

    @Column(name = "fecha_registro_sistema", updatable = false)
    private LocalDateTime fechaRegistroSistema;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetalleCompra> detalles = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void calcularTotalCompra() {
        if (this.detalles == null || this.detalles.isEmpty()) {
            this.totalCompra = 0.0;
        } else {
            this.totalCompra = this.detalles.stream()
                    .filter(d -> d.getSubtotal() != null)
                    .mapToDouble(DetalleCompra::getSubtotal)
                    .sum();
        }
    }
}
