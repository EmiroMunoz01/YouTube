package com.inventario.empleado.controlador;



import com.inventario.empleado.modelo.Empleado;
import com.inventario.empleado.servicio.ServicioEmpleado;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresa/empleado")
public class ControladorEmpleado {

    private final ServicioEmpleado servicioEmpleado;

    public ControladorEmpleado(ServicioEmpleado servicioEmpleado){
        this.servicioEmpleado = servicioEmpleado;

    }

    @GetMapping("/obtener-todos")
    public List<Empleado> retornarEmpleados(){
        return servicioEmpleado.listarEmpleados();
    }

    @GetMapping("/listar-empleados/{ciudad}")
    public List<Empleado> retornarEmpleadosPorCiudad(@PathVariable String ciudad){
        return servicioEmpleado.buscarPorCiudad(ciudad);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEmpleado(@PathVariable Long id){
    servicioEmpleado.eliminarPorId(id);
    }

    @PostMapping("/crear")
    public Empleado crearEmpleado(@RequestBody Empleado empleado){
        return servicioEmpleado.crearEmpleado(empleado);
    }

    @PutMapping("/actualizar/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){
        return servicioEmpleado.actualizar(id, empleado);
    }

    @GetMapping("/buscar-id/{id}")
    public Empleado retornarEmpleadoPorId(@PathVariable Long id){
        return servicioEmpleado.buscarPorId(id);
    }


}
