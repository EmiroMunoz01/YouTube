package com.example.demo.controlador.VISTA;


import com.example.demo.dto.ProveedorCrearDTO;
import com.example.demo.dto.ProveedorDTO;
import com.example.demo.modelo.compra.Proveedor;
import com.example.demo.servicio.ServicioProveedor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("compudorado/ui")
public class ControladorProveedorVista {

    private final ServicioProveedor servicioProveedor;

    public ControladorProveedorVista(ServicioProveedor servicioProveedor) {
        this.servicioProveedor = servicioProveedor;
    }

    //1. crear proveedor
    @PostMapping("/proveedor/crear")
    public String crearProveedor(@ModelAttribute("proveedor") ProveedorCrearDTO proveedorDTO) {
        Proveedor proveedor = convertirDTOaEntidad(proveedorDTO);
        servicioProveedor.crearProveedor(proveedor);
        return "redirect:/compudorado/ui/proveedor/listar";
    }


    public Proveedor convertirDTOaEntidad(ProveedorCrearDTO dto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(dto.getNombre());

        return proveedor;
    }

    @GetMapping("/proveedor/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("proveedor", new ProveedorDTO());
        return "proveedor/crear";
    }

    //2. listar proveedor
    @GetMapping("/proveedor/listar")
    public String listar(Model model){
        List<ProveedorDTO> listaProveedores = servicioProveedor.listarProveedores();
        model.addAttribute("proveedores", listaProveedores);
        return "proveedor/listar";
    }










    //3. listar proveedor por id
    @GetMapping("/listar-por-id/{id}")
    public ResponseEntity<Proveedor> listarPorId(@PathVariable Long id){
        Proveedor proveedor = servicioProveedor.buscarProveedorPorId(id);
        return ResponseEntity.ok(proveedor);
    }

    //4. actualizar proveedor
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proveedor> modificar(@PathVariable Long id, @RequestBody Proveedor proveedor){

        Proveedor proveedor1 = servicioProveedor.modificarProveedor(id, proveedor);

        return ResponseEntity.ok(proveedor1);
    }

    //5. eliminar proveedor
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        String proveedor = servicioProveedor.eliminarProveedor(id);
        return ResponseEntity.ok(proveedor);
    }


}
