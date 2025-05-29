package com.example.demo.repositorio;

import com.example.demo.modelo.compra.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCompra extends JpaRepository<Compra, Long> {
}
