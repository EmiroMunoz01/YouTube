package com.inventario.empleado.servicio.compra;


import com.inventario.empleado.modelo.Proveedor;
import com.inventario.empleado.repositorio.RepositorioProveedor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProveedor {

    private final RepositorioProveedor repositorioProveedor;

    public ServicioProveedor(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }


    //1. Crear proveedor
    public Proveedor crearProveedor(Proveedor proveedor) {
        return repositorioProveedor.save(proveedor);
    }

    //2. Modificar proveedor
    public Proveedor modificarProveedor(Long id, Proveedor proveedor) {

        //buscar proveedor para determinar si existe para realizar la modificacion
        Proveedor buscarProveedor = repositorioProveedor.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada"));

        //aqui se esta actualizando el proveedor
        buscarProveedor.setNombre(proveedor.getNombre());
        return repositorioProveedor.save(buscarProveedor);

    }

    //3. Listar proveedor
    public List<Proveedor> listarProveedores() {
        return repositorioProveedor.findAll();
    }


    //4. Eliminar proveedor
    public String eliminarProveedor(Long id) {

        Proveedor buscarProveedor = repositorioProveedor.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada"));

        repositorioProveedor.delete(buscarProveedor);

        return "Proveedor eliminado con exito";
    }

    //5. Listar por ID

    public Proveedor buscarProveedorPorId(Long id){

        return repositorioProveedor.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada"));

    }

}
