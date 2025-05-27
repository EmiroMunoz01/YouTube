package com.inventario.empleado.controlador.Vista.constructora;


import com.inventario.empleado.servicio.ServicioObrero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("construccion/obrero")
public class ControladorObreroVista {

    private final ServicioObrero servicioObrero;

    public ControladorObreroVista(ServicioObrero servicioObrero) {
        this.servicioObrero = servicioObrero;
    }



}
