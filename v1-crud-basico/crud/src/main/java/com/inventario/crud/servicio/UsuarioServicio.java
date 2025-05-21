package com.inventario.crud.servicio;

import com.inventario.crud.modelo.Usuario;
import com.inventario.crud.repositorio.UsuarioRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {


    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorID(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public void eliminarUsuario(Long id) {

        Usuario buscarUsuario = usuarioRepositorio.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado la entidad con el id: " + id));

        usuarioRepositorio.deleteById(buscarUsuario.getId());
    }


    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }


    public Usuario actualizarUsuario(Long id, Usuario usuario) {

        Usuario buscarUsuario = usuarioRepositorio.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado la entidad con el id: " + id));

        buscarUsuario.setNombre(usuario.getNombre());
        buscarUsuario.setIdentificacion(usuario.getIdentificacion());

        return usuarioRepositorio.save(buscarUsuario);
    }

}
