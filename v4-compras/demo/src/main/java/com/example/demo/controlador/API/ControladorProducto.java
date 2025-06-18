package com.example.demo.controlador.API;



import com.example.demo.modelo.Producto;
import com.example.demo.servicio.ServicioProducto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compudorado/producto")
public class ControladorProducto {

    private final ServicioProducto servicioProducto;

    public ControladorProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    //1. crear productos
    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto nuevoProducto = servicioProducto.crear(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    //2. listar productos
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> listarProductos = servicioProducto.listarProductos();
        return ResponseEntity.ok(listarProductos);
    }

    //3. listar productos por id
    @GetMapping("/listar-por-id/{id}")
    public ResponseEntity<Producto> listarPorId(@PathVariable Long id) {
        Producto productos = servicioProducto.buscarId(id);
        return ResponseEntity.ok(productos);
    }

    //4. actualizar productos
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> modificar(@PathVariable Long id, @RequestBody Producto productos) {

        Producto productos1 = servicioProducto.actualizar(id, productos);

        return ResponseEntity.ok(productos1);
    }

    //5. eliminar productos
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        String productos = servicioProducto.eliminarProducto(id);
        return ResponseEntity.ok(productos);
    }

}
