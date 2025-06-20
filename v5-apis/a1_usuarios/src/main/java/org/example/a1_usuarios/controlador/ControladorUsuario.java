package org.example.a1_usuarios.controlador;


import org.example.a1_usuarios.modelo.Usuario;
import org.example.a1_usuarios.servicio.ServicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("usuario")
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return servicioUsuario.listarUsuarios();
    }

    @GetMapping("/listar/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return servicioUsuario.buscarUsuarioPorId(id);
    }


    @PutMapping("/modificar/{id}")
    public Usuario modificarUsuario(@RequestBody Usuario usuario,@PathVariable Long id) {
        return servicioUsuario.modificarUsuario(usuario, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        servicioUsuario.eliminarUsuario(id);
    }


    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return servicioUsuario.crearUsuario(usuario);
    }


}
