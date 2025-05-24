package com.inventario.empleado.repositorio;

import com.inventario.empleado.modelo.EntidadIngeniero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioIngeniero extends JpaRepository<EntidadIngeniero, Long> {
}
