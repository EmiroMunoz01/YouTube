package com.example.demo.controlador;

import com.example.demo.modelo.compra.Proveedor;
import com.example.demo.servicio.ServicioProveedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compudorado/proveedor")
public class ControladorProveedor {

    private final ServicioProveedor servicioProveedor;

    public ControladorProveedor(ServicioProveedor servicioProveedor) {
        this.servicioProveedor = servicioProveedor;
    }

    //1. crear proveedor
    @PostMapping("/crear")
    public ResponseEntity<Proveedor> crear(@RequestBody Proveedor proveedor) {
        Proveedor nuevoProveedor = servicioProveedor.crearProveedor(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
    }

    //2. listar proveedor
    @GetMapping("/listar")
    public ResponseEntity <List<Proveedor>> listar(){
        List<Proveedor> listaProveedores = servicioProveedor.listarProveedores();
        return ResponseEntity.ok(listaProveedores);
    }

    //3. listar proveedor por id
    @GetMapping("/listar-por-id/{id}")
    public ResponseEntity<Proveedor> listarPorId(@PathVariable Long id){
        Proveedor proveedor = servicioProveedor.buscarProveedorPorId(id);
        return ResponseEntity.ok(proveedor);
    }

    //4. actualizar proveedor
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proveedor> modificar(@PathVariable Long id, @RequestBody Proveedor proveedor){

        Proveedor proveedor1 = servicioProveedor.modificarProveedor(id, proveedor);

        return ResponseEntity.ok(proveedor1);
    }

    //5. eliminar proveedor
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        String proveedor = servicioProveedor.eliminarProveedor(id);
        return ResponseEntity.ok(proveedor);
    }


}
