package com.example.demo.repositorio;



import com.example.demo.modelo.compra.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProveedor extends JpaRepository<Proveedor, Long> {
}
