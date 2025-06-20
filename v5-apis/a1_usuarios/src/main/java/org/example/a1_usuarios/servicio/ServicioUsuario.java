package org.example.a1_usuarios.servicio;

import jakarta.persistence.EntityNotFoundException;
import org.example.a1_usuarios.modelo.Usuario;
import org.example.a1_usuarios.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario {


    private final RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public Usuario modificarUsuario(Usuario usuario, Long id) {

        Usuario usuario1 = repositorioUsuario.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));

        usuario1.setNombre(usuario.getNombre());
        usuario1.setIdentificacion(usuario.getIdentificacion());

        return repositorioUsuario.save(usuario1);
    }


    public void eliminarUsuario(Long id) {
        repositorioUsuario.deleteById(id);
    }


    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.findAll();
    }


    public Usuario buscarUsuarioPorId(Long id) {
        return repositorioUsuario.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
    }
}
