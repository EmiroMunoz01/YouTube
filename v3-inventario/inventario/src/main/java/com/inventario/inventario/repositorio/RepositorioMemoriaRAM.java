package com.inventario.inventario.repositorio;

import com.inventario.inventario.modelo.MemoriaRAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMemoriaRAM extends JpaRepository<MemoriaRAM, Long> {
}
