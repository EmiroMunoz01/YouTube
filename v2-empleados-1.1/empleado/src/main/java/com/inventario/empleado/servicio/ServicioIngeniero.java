package com.inventario.empleado.servicio;

import com.inventario.empleado.modelo.EntidadIngeniero;
import com.inventario.empleado.repositorio.RepositorioIngeniero;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioIngeniero {

    private final RepositorioIngeniero repositorioIngeniero;

    public ServicioIngeniero(RepositorioIngeniero repositorioIngeniero) {
        this.repositorioIngeniero = repositorioIngeniero;
    }

    //1. Listar los ingenieros
    public List<EntidadIngeniero> listarIngenieros() {
        return repositorioIngeniero.findAll();
    }

    //2. Crear Ingeniero
    public EntidadIngeniero crearIngeniero(EntidadIngeniero EntidadIngeniero) {
        return repositorioIngeniero.save(EntidadIngeniero);
    }

    //3. Actualizar Ingeniero
    public EntidadIngeniero actualizarIngeniero(Long id, EntidadIngeniero EntidadIngeniero) {

        EntidadIngeniero buscarIngeniero = repositorioIngeniero.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada, id: " + id));

        buscarIngeniero.setNombre(EntidadIngeniero.getNombre());
        buscarIngeniero.setCedula(EntidadIngeniero.getCedula());
        buscarIngeniero.setSalario(EntidadIngeniero.getSalario());
        buscarIngeniero.setDepartamento(EntidadIngeniero.getDepartamento());
        buscarIngeniero.setObreros(EntidadIngeniero.getObreros());
        buscarIngeniero.setObra(EntidadIngeniero.getObra());

        return repositorioIngeniero.save(buscarIngeniero);
    }

    //4. Buscar Ingeniero por ID
    public EntidadIngeniero buscarIngenieroPorId(Long id) {
        return repositorioIngeniero.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada, id: " + id));
    }

    //5. Eliminar Ingeniero
    public String eliminarIngeniero(Long id) {

        repositorioIngeniero.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada, id: " + id));
        return "Ingeniero identificado con id: " + id + " eliminado con exito.";

    }

}
