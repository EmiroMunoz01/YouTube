package com.example.demo.controlador.API;

import com.example.demo.dto.CompraDTO;
import com.example.demo.modelo.compra.Compra;
import com.example.demo.servicio.ServicioCompra;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compudorado/compra")
public class ControladorCompra {

    private final ServicioCompra compraService;


    public ControladorCompra(ServicioCompra compraService) {
        this.compraService = compraService;
    }


    @PostMapping("/crear")
    public ResponseEntity<Compra> crearCompra(@Valid @RequestBody CompraDTO compraDTO) {

        Compra nuevaCompra = compraService.crearCompra(compraDTO);
        return ResponseEntity.ok(nuevaCompra); // ¡Mucho más limpio aquí!
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> obtenerCompraPorId(@PathVariable Long id) {
        return compraService.obtenerCompraPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CompraDTO>> obtenerTodasLasCompras() {
        List<CompraDTO> compras = compraService.obtenerTodasLasCompras();
        if (compras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(compras);
    }


}
