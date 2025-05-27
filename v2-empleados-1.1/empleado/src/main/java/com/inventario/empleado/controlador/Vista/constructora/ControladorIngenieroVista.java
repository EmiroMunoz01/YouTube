package com.inventario.empleado.controlador.Vista.constructora;

import com.inventario.empleado.modelo.EntidadIngeniero;
import com.inventario.empleado.servicio.ServicioIngeniero;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/ui/ingenieros")
public class ControladorIngenieroVista {

    private final ServicioIngeniero servicioIngeniero;

    public ControladorIngenieroVista(ServicioIngeniero servicioIngeniero) {
        this.servicioIngeniero = servicioIngeniero;
    }


    @GetMapping("/listar-ingeniero")
    public String mostrarIngenieros(Model model) {
        List<EntidadIngeniero> Ingenieros = servicioIngeniero.listarIngenieros();
        model.addAttribute("titulo", "Todos los Ingenieros de la empresa");
        model.addAttribute("Ingenieros", Ingenieros);

        return "ingenieros/listar-ingeniero";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoIngeniero(Model model) {

        model.addAttribute("ingeniero", new EntidadIngeniero());
        model.addAttribute("titulo", "Registrar Nuevo Ingeniero");

        return "ingenieros/formulario-ingeniero";
    }


    @PostMapping("/guardar")
    public String guardarIngeniero(@Valid @ModelAttribute("ingeniero") EntidadIngeniero entidadIngeniero,
                                   BindingResult result,
                                   Model model,
                                   RedirectAttributes redirectAttributes){

        // Si hay errores de validación, vuelve a mostrar el formulario con los errores
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Registrar Nuevo Ingeniero (Corregir Errores)");
            // No es necesario volver a añadir 'ingeniero' al modelo, @ModelAttribute ya lo hace
            return "ingenieros/formulario-ingeniero";
        }

        try {
            servicioIngeniero.crearIngeniero(entidadIngeniero);
            redirectAttributes.addFlashAttribute("mensajeExito", "Ingeniero registrado exitosamente!");
            return "redirect:/ui/ingenieros/listar-ingeniero"; // Redirige a la lista de ingenieros
        } catch (Exception e) { // Captura cualquier otra excepción del servicio
            // Loggear el error e.printStackTrace(); o con un logger
            model.addAttribute("titulo", "Registrar Nuevo Ingeniero");
            model.addAttribute("mensajeError", "Error al guardar el ingeniero: " + e.getMessage());
            // model.addAttribute("ingeniero", entidadIngeniero); // Ya está por @ModelAttribute
            return "ingenieros/formulario-ingeniero";
        }
    }

}