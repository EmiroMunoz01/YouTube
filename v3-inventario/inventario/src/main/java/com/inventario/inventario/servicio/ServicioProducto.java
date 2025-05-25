package com.inventario.inventario.servicio;

import com.inventario.inventario.modelo.Producto;
import com.inventario.inventario.repositorio.RepositorioProducto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }


    public Producto crear(Producto producto) {
        return repositorioProducto.save(producto);
    }

    public Producto actualizar(Long id, Producto producto) {

        Producto buscarProducto = repositorioProducto.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada."));

        buscarProducto.setNombre(producto.getNombre());
        buscarProducto.setDescripcion(producto.getDescripcion());
        buscarProducto.setValor_unitario(producto.getValor_unitario());
        buscarProducto.setCantidad(producto.getCantidad());
        buscarProducto.setCantidad(producto.getCantidad());
        buscarProducto.setCategoria(producto.getCategoria());

        return repositorioProducto.save(buscarProducto);

    }



    public String eliminarProducto(Long id){
        Producto buscarProducto = repositorioProducto.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada."));

        repositorioProducto.delete(buscarProducto);

        return "Producto eliminado con exito";
    }


    public List<Producto> listarProductos(){
        return  repositorioProducto.findAll();
    }

    public Producto buscarId(Long id){
        Producto buscarProducto = repositorioProducto.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada."));

        return buscarProducto;
    }

}
