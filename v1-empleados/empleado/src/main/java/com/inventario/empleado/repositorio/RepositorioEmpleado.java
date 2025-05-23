package com.inventario.empleado.repositorio;

import com.inventario.empleado.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Long> {

    List<Empleado> findEmpleadoByCiudad(String ciudad);

}
