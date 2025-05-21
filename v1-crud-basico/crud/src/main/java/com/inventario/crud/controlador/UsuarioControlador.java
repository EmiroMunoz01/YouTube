package com.inventario.crud.controlador;

import com.inventario.crud.modelo.Usuario;
import com.inventario.crud.servicio.UsuarioServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;


    public UsuarioControlador(UsuarioServicio usuarioServicio){
        this.usuarioServicio= usuarioServicio;
    }


    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioServicio.guardarUsuario(usuario);
    }


    @GetMapping("/buscar-id/{id}")
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable Long id){
        return usuarioServicio.buscarUsuarioPorID(id);
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios(){
        return usuarioServicio.listarUsuarios();
    }


    @DeleteMapping("/eliminar-id/{id}")
    public void eliminarUsuario(@PathVariable Long id){
        usuarioServicio.eliminarUsuario(id);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioServicio.actualizarUsuario(id, usuario);
    }

}
