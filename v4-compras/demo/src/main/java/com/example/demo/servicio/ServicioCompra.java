package com.example.demo.servicio;

import com.example.demo.dto.CompraDTO;
import com.example.demo.dto.ProductoDTORequest;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.compra.Compra;
import com.example.demo.modelo.compra.DetalleCompra;
import com.example.demo.modelo.compra.Proveedor;
import com.example.demo.repositorio.RepositorioCompra;
import com.example.demo.repositorio.RepositorioProducto;
import com.example.demo.repositorio.RepositorioProveedor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioCompra {

    private final RepositorioCompra repositorioCompra;
    private final RepositorioProducto repositorioProducto;
    private final RepositorioProveedor repositorioProveedor;

    public ServicioCompra(RepositorioCompra repositorioCompra, RepositorioProveedor repositorioProveedor, RepositorioProducto repositorioProducto){
        this.repositorioCompra = repositorioCompra;
        this.repositorioProducto = repositorioProducto;
        this.repositorioProveedor = repositorioProveedor;
    }

    public Compra crearCompra(CompraDTO compraDTO) {
        Compra compra = new Compra();

        compra.setFechaCompra(LocalDateTime.now());

        // Aquí es donde buscas y asignas el proveedor
        // La validación @NotNull del DTO ya hizo que proveedorId no sea null.
        Proveedor proveedor = repositorioProveedor.findById(compraDTO.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + compraDTO.getProveedorId()));
        compra.setProveedor(proveedor);

        // ... Lógica para procesar detalles (creando productos nuevos como discutimos) ...
        List<DetalleCompra> detalles = compraDTO.getDetalles().stream()
                .map(detalleDTO -> {
                    // ... (lógica para crear Producto producto = new Producto()... y guardarlo) ...
                    Producto producto = new Producto();
                    producto.setNombre(detalleDTO.getProductoInfo().getNombre());
                    producto.setDescripcion(detalleDTO.getProductoInfo().getDescripcion());
                    producto.setCategoria(detalleDTO.getProductoInfo().getCategoria());

                    // ... setear otros campos del producto y guardarlo ...
                    producto = repositorioProducto.save(producto);


                    DetalleCompra detalleCompra = new DetalleCompra();
                    detalleCompra.setProducto(producto);
                    detalleCompra.setCantidad(detalleDTO.getCantidad());
                    detalleCompra.setCantidad(detalleDTO.getCantidad());
                    detalleCompra.setPrecioUnitarioCompra(detalleDTO.getPrecioUnitarioCompra());
                    detalleCompra.setCompra(compra);
                    return detalleCompra;
                })
                .collect(Collectors.toList());

        compra.setDetalles(detalles);
        return repositorioCompra.save(compra);
    }



    public Optional<Compra> obtenerCompraPorId(Long id) {
        return repositorioCompra.findById(id);
    }

    public List<Compra> obtenerTodasLasCompras() {
        return repositorioCompra.findAll();
    }
}
