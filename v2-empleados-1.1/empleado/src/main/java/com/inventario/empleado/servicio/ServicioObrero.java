package com.inventario.empleado.servicio;


import com.inventario.empleado.modelo.EntidadObrero;
import com.inventario.empleado.repositorio.RepositorioObrero;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioObrero {

    private final RepositorioObrero repositorioObrero;

    public ServicioObrero(RepositorioObrero repositorioObrero) {
        this.repositorioObrero = repositorioObrero;
    }

    //1. Listar los obreros
    public List<EntidadObrero> listarObreros() {
        return repositorioObrero.findAll();
    }

    //2. Crear obrero
    public EntidadObrero crearObrero(EntidadObrero entidadObrero) {
        return repositorioObrero.save(entidadObrero);
    }

    //3. Actualizar obrero
    public EntidadObrero actualizarObrero(Long id, EntidadObrero entidadObrero) {

        EntidadObrero buscarObrero = repositorioObrero.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada, id: " + id));

        buscarObrero.setNombre(entidadObrero.getNombre());
        buscarObrero.setCedula(entidadObrero.getCedula());
        buscarObrero.setSalario(entidadObrero.getSalario());
        buscarObrero.setDepartamento(entidadObrero.getDepartamento());
        buscarObrero.setIngenieroLider(entidadObrero.getIngenieroLider());
        buscarObrero.setVehiculo(entidadObrero.getVehiculo());

        return repositorioObrero.save(buscarObrero);
    }

    //4. Buscar obrero por ID
    public EntidadObrero buscarObreroPorId(Long id){
        return repositorioObrero.findById(id).orElseThrow(()-> new EntityNotFoundException("Entidad no encontrada, id: " + id));
    }

    //5. Eliminar obrero
    public String eliminarObrero(Long id){

        repositorioObrero.findById(id).orElseThrow(()-> new EntityNotFoundException("Entidad no encontrada, id: " + id));

        return "Obrero identificado con id: " + id + " eliminado con exito.";

    }


}
