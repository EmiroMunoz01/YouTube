package com.example.demo.controlador.VISTA;


import com.example.demo.dto.CompraDTO;
import com.example.demo.modelo.compra.Compra;
import com.example.demo.servicio.ServicioCompra;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("compudorado/compra/ui")
public class ControladorCompraVista {

    private final ServicioCompra compraService;


    public ControladorCompraVista(ServicioCompra compraService) {
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
    public String listarCompras(Model model) {
        List<CompraDTO> comprasLista = compraService.obtenerTodasLasCompras();
        model.addAttribute("compra/listar", comprasLista);
        return "compra/listar";
    }


}
