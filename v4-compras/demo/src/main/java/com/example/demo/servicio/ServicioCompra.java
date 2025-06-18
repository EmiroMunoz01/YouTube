package com.example.demo.servicio;

import com.example.demo.dto.CompraDTO;
import com.example.demo.dto.DetalleCompraDTO;
import com.example.demo.dto.ProductoDTORequest;
import com.example.demo.dto.ProveedorDTO;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.compra.Compra;
import com.example.demo.modelo.compra.DetalleCompra;
import com.example.demo.modelo.compra.Proveedor;
import com.example.demo.repositorio.RepositorioCompra;
import com.example.demo.repositorio.RepositorioProducto;
import com.example.demo.repositorio.RepositorioProveedor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ServicioCompra {

    private final RepositorioCompra repositorioCompra;
    private final RepositorioProducto repositorioProducto;
    private final RepositorioProveedor repositorioProveedor;

    public ServicioCompra(RepositorioCompra repositorioCompra, RepositorioProveedor repositorioProveedor, RepositorioProducto repositorioProducto) {
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
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: "
                        + compraDTO.getProveedorId()));

        compra.setProveedor(proveedor);

        // ... Lógica para procesar detalles (creando productos nuevos como discutimos) ...
        List<DetalleCompra> detalles = new ArrayList<>(); // Se crea una lista vacía para almacenar los resultados

        for (DetalleCompraDTO detalleDTO : compraDTO.getDetalles()) { // Se itera sobre la lista de DetalleCompraDTO
            // Lógica para crear y guardar el Producto
            Producto producto = new Producto();
            producto.setNombre(detalleDTO.getProductoInfo().getNombre());
            producto.setDescripcion(detalleDTO.getProductoInfo().getDescripcion());
            producto.setCategoria(detalleDTO.getProductoInfo().getCategoria());

            // ... setear otros campos del producto ...

            // Se guarda el producto y se reasigna la variable 'producto'
            // con el objeto devuelto por el repositorio (que podría tener un ID asignado, por ejemplo)
            producto = repositorioProducto.save(producto);

            // Crear y configurar el DetalleCompra
            DetalleCompra detalleCompra = new DetalleCompra();
            detalleCompra.setProducto(producto);
            detalleCompra.setCantidad(detalleDTO.getCantidad());
            detalleCompra.setPrecioUnitarioCompra(detalleDTO.getPrecioUnitarioCompra());
            detalleCompra.setCompra(compra); // 'compra' debe estar definida en el alcance exterior

            detalles.add(detalleCompra); // Se añade el DetalleCompra creado a la lista
        }

        compra.setDetalles(detalles);
        return repositorioCompra.save(compra);
    }

    public Optional<Compra> obtenerCompraPorId(Long id) {
        return repositorioCompra.findById(id);
    }

    public List<CompraDTO> obtenerTodasLasCompras() {


        List<Compra> compras = repositorioCompra.findAll();
        List<CompraDTO> comprasDTO = new ArrayList<>();

        // Iterar sobre cada compra generada por el repositorio
        for (Compra compra : compras) {

            // Arreglo para almacenar los detalleCompraDTO
            List<DetalleCompraDTO> detallesDTO = new ArrayList<>();

            for (DetalleCompra detalle : compra.getDetalles()) {

                Producto producto = detalle.getProducto();

                // Convertir Producto a ProductoDTORequest
                ProductoDTORequest productoDTORequest = new ProductoDTORequest(

                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getCategoria()
                        // Agregar todos los campos que necesite ProductoDTORequest
                );

                // Crear el DetalleCompraDTO con el DTO del producto
                detallesDTO.add(new DetalleCompraDTO(
                        productoDTORequest,
                        detalle.getCantidad(),
                        detalle.getPrecioUnitarioCompra()
                ));
                // Crear CompraDTO con los datos correctos
                comprasDTO.add(new CompraDTO(compra.getFechaCompra(), compra.getProveedor().getId(),
                        detallesDTO));
            }

        }


        return comprasDTO;


    }







}
