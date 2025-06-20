package com.example.demo.servicio;

import com.example.demo.dto.*;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.compra.Compra;
import com.example.demo.modelo.compra.DetalleCompra;
import com.example.demo.modelo.compra.Proveedor;
import com.example.demo.repositorio.RepositorioProveedor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioProveedor {

    private final RepositorioProveedor repositorioProveedor;

    public ServicioProveedor(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }


    //1. Crear proveedor
    public ProveedorCrearDTO crearProveedor(Proveedor proveedor) {

        repositorioProveedor.save(proveedor);

        ProveedorCrearDTO proveedorCrearDTO = new ProveedorCrearDTO();
        proveedorCrearDTO.setNombre(proveedor.getNombre());

        return proveedorCrearDTO;

    }


    //2. Modificar proveedor
    public Proveedor modificarProveedor(Long id, Proveedor proveedor) {

        //buscar proveedor para determinar si existe para realizar la modificacion
        Proveedor buscarProveedor = repositorioProveedor.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada"));

        //aqui se esta actualizando el proveedor
        buscarProveedor.setNombre(proveedor.getNombre());
        return repositorioProveedor.save(buscarProveedor);

    }

    //3. Listar proveedor
    public List<ProveedorDTO> listarProveedores() {

        List<Proveedor> listaProveedores = repositorioProveedor.findAll();
        List<ProveedorDTO> listaProveedorDTO = new ArrayList<>();

        // Iterar sobre cada proveedor generado por el repositorio
        for (Proveedor proveedor : listaProveedores) {

            // Arreglo para almacenar las comprasDTO
            List<CompraDTO> comprasDTO = new ArrayList<>();

            // Iterar cada compra del proveedor para convertirla en CompraDTO
            for (Compra compra : proveedor.getCompras()) {

                // Convertir DetalleCompra a DetalleCompraDTO
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
                }


                // Crear CompraDTO con los datos correctos
                comprasDTO.add(new CompraDTO(compra.getFechaCompra(), compra.getProveedor().getId(), // Obtener ID del proveedor desde la relación
                        detallesDTO));
            }

            listaProveedorDTO.add(new ProveedorDTO(proveedor.getNombre(), comprasDTO));
        }

        return listaProveedorDTO;
    }

    //4. Eliminar proveedor
    public String eliminarProveedor(Long id) {

        Proveedor buscarProveedor = repositorioProveedor.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada"));

        repositorioProveedor.delete(buscarProveedor);

        return "Proveedor eliminado con exito";
    }

    //5. Listar por ID

    public Proveedor buscarProveedorPorId(Long id) {

        return repositorioProveedor.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada"));

    }

}
