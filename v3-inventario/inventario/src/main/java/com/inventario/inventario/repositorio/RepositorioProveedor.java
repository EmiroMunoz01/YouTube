package com.inventario.inventario.repositorio;

import com.inventario.inventario.modelo.compra.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProveedor extends JpaRepository<Proveedor, Long> {
}
