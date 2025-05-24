package com.inventario.empleado.controlador;

import com.inventario.empleado.modelo.EntidadObrero;
import com.inventario.empleado.servicio.ServicioObrero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("construccion/obrero")
public class ControladorObrero {

    private final ServicioObrero servicioObrero;

    public ControladorObrero(ServicioObrero servicioObrero) {
        this.servicioObrero = servicioObrero;
    }

    @PostMapping("/crear")
    public ResponseEntity<EntidadObrero> CrearObrero(@RequestBody EntidadObrero entidadObrero) {
        EntidadObrero crearObrero = servicioObrero.crearObrero(entidadObrero);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearObrero);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EntidadObrero>> mostrarObreros() {
        List<EntidadObrero> obreros = servicioObrero.listarObreros();
        return ResponseEntity.ok(obreros);
    }

    @GetMapping("/listar-por-id/{id}")
    public ResponseEntity<EntidadObrero> buscarObrero(@PathVariable Long id) {
        EntidadObrero buscarObrero = servicioObrero.buscarObreroPorId(id);
        return ResponseEntity.ok(buscarObrero);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EntidadObrero> actualizarObrero(@PathVariable Long id, @RequestBody EntidadObrero obrero) {
        EntidadObrero actualizar = servicioObrero.actualizarObrero(id, obrero);
        return ResponseEntity.ok(actualizar);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarObrero(@PathVariable Long id) {
        String mensaje = servicioObrero.eliminarObrero(id);
        return ResponseEntity.ok(mensaje);
    }

}
