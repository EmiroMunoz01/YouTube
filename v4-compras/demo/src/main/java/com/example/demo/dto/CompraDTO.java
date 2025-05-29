package com.example.demo.dto;

import com.example.demo.modelo.compra.Proveedor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CompraDTO {

    private LocalDateTime fechaCompra;

    @NotNull
    @Valid
    private Long  proveedorId;
    @NotNull @NotEmpty @Valid
    private List<DetalleCompraDTO> detalles;


}
