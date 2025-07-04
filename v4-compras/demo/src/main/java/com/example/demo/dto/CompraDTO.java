package com.example.demo.dto;


import jakarta.validation.Valid;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {

    private LocalDateTime fechaCompra;

    @NotNull
    private Long proveedorId;

    @NotNull
    @Valid
    private List<DetalleCompraDTO> detalles;


}
