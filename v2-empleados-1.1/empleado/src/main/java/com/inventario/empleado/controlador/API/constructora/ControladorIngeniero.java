package com.inventario.empleado.controlador.API.constructora;

import com.inventario.empleado.modelo.EntidadIngeniero;
import com.inventario.empleado.servicio.ServicioIngeniero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("construccion/ingeniero")
public class ControladorIngeniero {

    private final ServicioIngeniero servicioIngeniero;

    public ControladorIngeniero(ServicioIngeniero servicioIngeniero) {
        this.servicioIngeniero = servicioIngeniero;
    }

    @PostMapping("/crear")
    public ResponseEntity<EntidadIngeniero> CrearIngeniero(@RequestBody EntidadIngeniero entidadIngeniero) {
        EntidadIngeniero crearIngeniero = servicioIngeniero.crearIngeniero(entidadIngeniero);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearIngeniero);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EntidadIngeniero>> mostrarIngenieros() {
        List<EntidadIngeniero> Ingenieros = servicioIngeniero.listarIngenieros();
        return ResponseEntity.ok(Ingenieros);
    }




    @GetMapping("/listar-por-id/{id}")
    public ResponseEntity<EntidadIngeniero> buscarIngeniero(@PathVariable Long id) {
        EntidadIngeniero buscarIngeniero = servicioIngeniero.buscarIngenieroPorId(id);
        return ResponseEntity.ok(buscarIngeniero);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EntidadIngeniero> actualizarIngeniero(@PathVariable Long id, @RequestBody EntidadIngeniero Ingeniero) {
        EntidadIngeniero actualizar = servicioIngeniero.actualizarIngeniero(id, Ingeniero);
        return ResponseEntity.ok(actualizar);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarIngeniero(@PathVariable Long id) {
        String mensaje = servicioIngeniero.eliminarIngeniero(id);
        return ResponseEntity.ok(mensaje);
    }

}
