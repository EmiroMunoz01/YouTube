package com.inventario.empleado.servicio;

import com.inventario.empleado.modelo.Empleado;
import com.inventario.empleado.repositorio.RepositorioEmpleado;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleado {


    private final RepositorioEmpleado repositorioEmpleado;

    public ServicioEmpleado(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    // 1. Obtener todos los empleados

    public List<Empleado> listarEmpleados() {
        return repositorioEmpleado.findAll();
    }

    // 2. Obtener empleado por ID

    public Empleado buscarPorId(Long id){
        return repositorioEmpleado.findById(id).orElseThrow(()-> new EntityNotFoundException("No se ha encontrado el usuario con el id"+ id));
    }

    // 3. Eliminar empleado por ID

    public void eliminarPorId(Long id){

        repositorioEmpleado.findById(id).orElseThrow(()-> new EntityNotFoundException("No se ha encontrado el usuario con el id"+ id));
        repositorioEmpleado.deleteById(id);

    }

    // 4. Actualizar Empleado

    public Empleado actualizar(Long id, Empleado modificar){


        Empleado buscarEmpleado = repositorioEmpleado.findById(id).orElseThrow(()-> new EntityNotFoundException("No se ha encontrado el usuario con el id"+ id));

        buscarEmpleado.setNombre(modificar.getNombre());
        buscarEmpleado.setEdad(modificar.getEdad());
        buscarEmpleado.setCiudad(modificar.getCiudad());


        return repositorioEmpleado.save(buscarEmpleado);

    }

    // 5. Crear Empleado

    public Empleado crearEmpleado(Empleado empleadoNuevo){
        return repositorioEmpleado.save(empleadoNuevo);
    }


    // 6. Buscar Empleado Por Ciudad

   public List<Empleado> buscarPorCiudad(String ciudad){
        return repositorioEmpleado.findEmpleadoByCiudad(ciudad);

   }



}
