package com.inventario.empleado.repositorio;

import com.inventario.empleado.modelo.EntidadObrero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioObrero extends JpaRepository<EntidadObrero, Long> {


}
